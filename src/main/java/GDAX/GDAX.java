package GDAX;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sonnguyen on 3/11/18.
 */
public class GDAX {

    private static Logger logger = Logger.getLogger(GDAX.class.getName());
    private static Connection connection = null;
    private static String btc_insert = "INSERT IGNORE INTO btc_trade_history " +
            "(trade_id, time, price, size, side) VALUES " +
            "(?, ?, ?, ?, ?)";
    private static String bch_insert = "INSERT IGNORE INTO bch_trade_history " +
            "(trade_id, time, price, size, side) VALUES " +
            "(?, ?, ?, ?, ?)";
    private static String eth_insert = "INSERT IGNORE INTO eth_trade_history " +
            "(trade_id, time, price, size, side) VALUES " +
            "(?, ?, ?, ?, ?)";
    private static String ltc_insert = "INSERT IGNORE INTO ltc_trade_history " +
            "(trade_id, time, price, size, side) VALUES " +
            "(?, ?, ?, ?, ?)";

    public static void main(String[] args) throws Exception {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %2$s %5$s%6$s%n");
        connectToDatabase("jdbc:mysql://10.10.76.100:3306/gdax", "root", "a");

        while (true) {
            //BTC
            List<Trade> btcList = fetchTradeHistory("BTC-USD");
            int btcInsertResult = insertTradeHistory(btcList, btc_insert, "BTC-USD");

            //BCH
            List<Trade> bchList = fetchTradeHistory("BCH-USD");
            int bchInsertResult = insertTradeHistory(bchList, bch_insert, "BCH-USD");

            //ETH
            List<Trade> ethList = fetchTradeHistory("ETH-USD");
            int ethInsertResult = insertTradeHistory(ethList, eth_insert, "ETH-USD");

            //LTC
            List<Trade> ltcList = fetchTradeHistory("LTC-USD");
            int ltcInsertResult = insertTradeHistory(ltcList, ltc_insert, "LTC-USD");

            logger.info("Fetch " + btcList.size() + " BTC-USD, "
                    + bchList.size() + " BCH-USD, "
                    + ethList.size() + " ETH-USD, "
                    + ltcList.size() + " LTC-USD");
            logger.info("Insert +" + btcInsertResult + " BTC-USD, +"
                    + bchInsertResult + " BCH-USD, +"
                    + ethInsertResult + " ETH-USD, +"
                    + ltcInsertResult + " LTC-USD");
            logger.info("----------------------------------------");
            Thread.sleep(5000L);
        }
    }

    private static void connectToDatabase(String url, String user, String password) throws Exception {
        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("MySQL JDBC Driver Registered!");

        connection = (Connection) DriverManager
                .getConnection(url, user, password);

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    private static List<Trade> fetchTradeHistory(String cryptoType) throws Exception {
        String url = "https://api.gdax.com/products/" + cryptoType + "/trades";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");

        int responseCode = con.getResponseCode();
        logger.info("Sending 'GET' request to URL : " + url + " " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        ObjectMapper mapper = new ObjectMapper();
        List<Trade> trades = mapper.readValue(response.toString(),
                mapper.getTypeFactory().constructCollectionType(List.class, Trade.class));
        return trades;
    }

    private static int insertTradeHistory(List<Trade> tradeList,
                                          String insertStatement, String cryptoType) throws SQLException {
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(insertStatement);
        for (Trade trade : tradeList) {
            preparedStatement.setInt(1, trade.getTrade_id());
            preparedStatement.setString(2, trade.getTime());
            preparedStatement.setString(3, trade.getPrice());
            preparedStatement.setString(4, trade.getSize());
            preparedStatement.setString(5, trade.getSide());

            // execute insert SQL stetement
            preparedStatement.addBatch();
        }
        int[] numUpdates = preparedStatement.executeBatch();
        int count = 0;
        for (int update : numUpdates) {
            if (update == 1) count++;
        }
        return count;
    }
}

