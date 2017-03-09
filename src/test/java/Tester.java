import javax.net.ssl.HttpsURLConnection;
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonnguyen on 3/6/17.
 */
public class Tester {

    public static void main(String[] args) {
        try {
            List<Application> applications = new ArrayList<>();
            for (int i = 0; i < 5000; i++) {
                try {
                    URL url = new URL("https://egov.uscis.gov/casestatus/mycasestatus.do?appReceiptNum=YSC" +
                            (1790001000 + i));
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Cookie", "JSESSIONID=CFB3FDAE5793EE28782A42E5A52F55DF; JSESSIONID=abcfpc-kl7dAo-L2QYCQv; _gat=1; _ga=GA1.2.1513243995.1488689242; _gat_GSA_ENOR0=1; _ceg.s=omjfer; _ceg.u=omjfer; fsr.s=%7B%22v2%22%3A1%2C%22v1%22%3A1%2C%22rid%22%3A%22de358f8-93242934-e47f-8763-21615%22%2C%22cp%22%3A%7B%22delivery_src%22%3A%22none%22%2C%22Homepage%22%3A%22Y%22%7D%2C%22to%22%3A10%2C%22c%22%3A%22https%3A%2F%2Fwww.uscis.gov%2F%22%2C%22pv%22%3A94%2C%22lc%22%3A%7B%22d14%22%3A%7B%22v%22%3A83%2C%22s%22%3Atrue%7D%2C%22d13%22%3A%7B%22v%22%3A6%2C%22s%22%3Atrue%7D%2C%22d4%22%3A%7B%22v%22%3A1%2C%22s%22%3Afalse%7D%2C%22d10%22%3A%7B%22v%22%3A3%2C%22s%22%3Atrue%7D%2C%22d11%22%3A%7B%22v%22%3A1%2C%22s%22%3Atrue%7D%7D%2C%22cd%22%3A14%2C%22sd%22%3A10%2C%22mid%22%3A%22de358f8-93243377-0ed2-3461-17d20%22%2C%22rt%22%3Afalse%2C%22rc%22%3Atrue%2C%22f%22%3A1489046214542%2C%22l%22%3A%22en%22%2C%22i%22%3A-1%2C%22pn%22%3A10%7D; __utmt_GSA_CP=1; __utma=34570677.1513243995.1488689242.1489036970.1489046215.33; __utmb=34570677.5.10.1489046215; __utmc=34570677; __utmz=34570677.1489000657.29.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided)");

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    int first = response.indexOf("var completedActionListDate");
                    int second = response.indexOf("var currentHistPage");

                    System.out.println(response);

                    String str = response.substring(first, second).trim();

                    String date = str.split("\\;")[0].trim();
                    String action = str.split("\\;")[1].trim();

                    if (date.contains(",") && action.contains(",")) {
                        Application application = new Application(date, action);
                        applications.add(application);
                    }
                    System.out.println(i);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            String fileName = "/Users/sonnguyen/Desktop/text.txt";
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Application application : applications) {
                bufferedWriter.write(application.toString());
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static class Application {

        List<String> dateList = new ArrayList<>();
        List<String> actionList = new ArrayList<>();

        public Application(String date, String action) {
            String temp = date.substring(date.indexOf('[') + 1, date.indexOf(']')).trim();
            String str[] = temp.split(",");
            for (String s : str) {
                dateList.add(s.substring(1, s.length() - 1));
            }

            temp = action.substring(action.indexOf('[') + 1, action.indexOf(']')).trim();
            str = temp.split("\",");
            for (String s : str) {
                actionList.add(s.substring(1, s.length()));
            }
        }

        public void printConsole() {
            for (int i = 0; i < dateList.size(); i++) {
                System.out.println(dateList.get(i) + " : " + actionList.get(i));
            }
            System.out.println("---------------------------------------------");
        }

        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < dateList.size(); i++) {
                buffer.append(dateList.get(i) + " : " + actionList.get(i) + '\n');
            }
            buffer.append("---------------------------------------------\n");
            return buffer.toString();
        }
    }
}
