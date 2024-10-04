package StreamOperations;


import java.security.MessageDigest;

public class MessagesMuleESB {

    public static void main(String[] args) {

        try {

            String      data ="ECO1222333333504"+"ECOBANKMOBILE"+"eco123456";

            // String      data ="ECO12223333216"+"RIB"+"eco123456";

            // String      data ="ECO12223111127"+"CHINAEE"+"123456";

//String      data ="6112234ECOBANKMOBILEeco123456";

            String  test =Hash512Msg(data);



            System.out.println("test  "+test);





        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static String Hash512Msg(String data)
    {
        String isValid = "";
        try
        {

            System.out.println("STOKEN::" + data);
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            // ** NOTE all bytes that are retrieved from the data string must be done so using UTF-8 Character Set.
            byte[] hashBytes = data.getBytes("UTF-8");
            //Create the hash bytes from the data
            byte[] messageDigest = digest.digest(hashBytes);
            //Create a HEX string from the hashed data

            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < messageDigest.length; i++)
            {
                String h = Integer.toHexString(0xFF & messageDigest[i]);

                while(h.length() < 2)

                    h = "0" + h;

                sb.append(h);
            }
            System.out.println("SBB-TOKEN:" + sb.toString());
            isValid = sb.toString();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return isValid;
    }
}