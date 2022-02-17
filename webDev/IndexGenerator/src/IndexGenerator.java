import java.io.*;
import java.util.*;
/**
 * Program to generate HTML boilerplate, automate repetitive code,
 * and generally avoid typing individual HTML as much as possible.
 * This code was created for the construction of griffincodes.tech,
 * and is purely a learning experience. All code in this java file
 * should be considered highly experimental, fundamentally broken,
 * and not to be trusted.
 * 
 * @author Griffin Pitts
 * @version Java 8
 */
public final class IndexGenerator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private IndexGenerator() {
    }

    // error message used in the catch statement for every method that writes to the output stream
    private static final String PRINT_ERR_MSG = "Error: condition violated - print failure for: ";

    private static final String MANDATORY_TAGS = "<!DOCTYPE html>\n<html lang=\"en-us\">\n<head>\n\t";
    private static final String WEBPAGE_TITLE = "<title>The Home for All Things Griffin Codes | griffincodes.tech</title>";
    private static final String WEBPAGE_CSS_LINK = "<link rel=\"stylesheet\" href=\"style.css\"/>";
    private static final String WEBPAGE_JS_LINK = "<script src=\"script.js\"></script>";

    private static final String META_HTTP_CONTENT = "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>";

    private static final String META_NAME_SCALE = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>";
    
    private static final String GOOGLE_FONT_A = "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"/>";
    private static final String GOOGLE_FONT_B = "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin/>";
    private static final String GOOGLE_FONT_C = "<link href=\"https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+Thai+Looped:wght@100;700&display=swap\" rel=\"stylesheet\"/>";

    /**
     * The following variables adjust the number of pre-formatted html sections are printed to the output stream, an array
     * of colors representing the color palette defined in the CSS code, and chosen for their boringly professional appearance;
     * however, bright grey was removed from section color palette due to text compatibility issues.
     */
    private static final int NUM_BASIC_SECTIONS = 6;
    private static final String[] BASIC_SECTION_COLOR = {"darkCornflowerBlue", "vistaBlue", "darkSilver", "darkCharcoal"};
    private static final String[] BASIC_SECTION_COLOR_HEX = {"20368F", "829CD0", "6D6D6D", "323232"};
    private static final Map<String, String> BASIC_SECTION_COLOR_MAP = new HashMap<>();
    private static final int BASIC_SECTION_COLOR_SIZE = BASIC_SECTION_COLOR.length;
    
    /**
     * Method for final variable color map creation
     */
    private static void addBasicSectionColors() {
        int i = 0;
        for(String s : BASIC_SECTION_COLOR) {
            BASIC_SECTION_COLOR_MAP.put(s, BASIC_SECTION_COLOR_HEX[i]);
            i++;
        }
    }

    /**
     * Computes {@code a} mod {@code b} as % should have been defined to work.
     *
     * @param a
     *            the number being reduced
     * @param b
     *            the modulus
     * @return the result of a mod b, which satisfies 0 <= {@code mod} < b
     * @requires b > 0
     * @ensures <pre>
     * 0 <= mod  and  mod < b  and
     * there exists k: integer (a = k * b + mod)
     * </pre>
     */
    private static int positiveMod(int a, int b) {
        assert b > 0 : "Violation of: b > 0";

        int mod = a % b;
        if (mod < 0) {
            mod += b;
        }
        return mod;
    }

    /**
     * Prints the "opening" tags for the generated HTML file as follows:
     * 
     * <!DOCTYPE html>
     * <html lang="en-us">
     * <head>
	 *     <!-- webpage jargon -->
	 *     <title>The Home for All Things Griffin Codes | griffincodes.tech</title>
	 *     <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	 *     <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
     *
	 *     <!-- webpage CSS -->
	 *     <link rel="stylesheet" href="style.css"/>
	 *     <!-- font imports -->
	 *     <link rel="preconnect" href="https://fonts.googleapis.com"/>
	 *     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
	 *     <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+Thai+Looped:wght@100;700&display=swap" rel="stylesheet"/>
     *
	 *     <!-- script declarations and their sources -->
	 *     <script src="script.js"></script>
     * </head>
     * 
     * @param fr 
     *          the output stream
     * @updates fr.content
     * @ensures fr.content = #fr.content * [the HTML "opening" tags]
     */
    private static void printHeader(FileWriter fr) {
        // This is a mess, but it's better than ctrl+c on every new homepage iteration
        try {
            fr.write(MANDATORY_TAGS + "<!-- webpage jargon -->\n\t" + WEBPAGE_TITLE + "\n\t" + META_HTTP_CONTENT + "\n\t" + META_NAME_SCALE + "\n\n\t<!-- webpage CSS -->\n\t" + WEBPAGE_CSS_LINK + "\n\t<!-- font imports -->\n\t"+ GOOGLE_FONT_A +"\n\t" + GOOGLE_FONT_B + "\n\t" + GOOGLE_FONT_C + "\n\n\t<!-- script declarations and their sources -->\n\t" + WEBPAGE_JS_LINK + "\n</head>");
            fr.write("\n");
        } catch (Exception e) {
            System.err.println(PRINT_ERR_MSG + "printHeader");
        }
    }

    private static void printH1(FileWriter fr) {
        try {
            fr.write("\t<h1 id=\"head\">Welcome Memers</h1>");
            fr.write("\n");
        } catch(Exception e) {
            System.err.println(PRINT_ERR_MSG + "printH1");
        }
    }

    private static void printH2(FileWriter fr) {
        try {
            fr.write("\t<h2 id=\"buttonHead\">\n\t\t<button type=\"button\" id=\"redButton\" onclick=\"changeFontRed()\">red</button>\n\t\t<button type=\"button\" id=\"defaultButton\" onclick=\"changeFontDefault()\">default</button>\n\t\t<button type=\"button\" id=\"blueButton\" onclick=\"changeFontBlue()\">blue</button>\n\t</h2>\n");
            fr.write("\t<div class=\"spacer layerWaveHeader\"></div>");
            fr.write("\n");
        } catch(Exception e) {
            System.err.println(PRINT_ERR_MSG + "printH2");
        }
    }

    private static void printH3(FileWriter fr) {
        try {

        } catch(Exception e) {
            System.err.println(PRINT_ERR_MSG + "printH3");
        }
    }

    private static void printH4(FileWriter fr) {
        try {

        } catch(Exception e) {
            System.err.println(PRINT_ERR_MSG + "printH4");
        }
    }

    private static void printH5(FileWriter fr) {
        try {

        } catch(Exception e) {
            System.err.println(PRINT_ERR_MSG + "printH5");
        }
    }

    private static void printH6(FileWriter fr) {
        try {

        } catch(Exception e) {
            System.err.println(PRINT_ERR_MSG + "printH6");
        }
    }

    private static void printBasicSection(FileWriter fr, int numSections) {
        try {
            for(int i = 0; i < numSections; i++) {
                String color = BASIC_SECTION_COLOR[positiveMod(i, BASIC_SECTION_COLOR_SIZE)];
                fr.write("\t<section class=\"" + color + "\">\n\t\t<p>We're no strangers to love\n\t\t  You know the rules and so do I\n\t\t A full commitment's what I'm thinking of\n\t\t  You wouldn't get this from any other guy\n\t\t</p>\n\t</section>");
                fr.write("\n");
            }
        } catch(Exception e) {
            System.err.println(PRINT_ERR_MSG + "printBasicSection, iteration unknown");
        }
    }

    private static void generateDiv(FileWriter fr) {
        try {
            fr.write("\t<div class=\"spacer layerWaveHeader\"></div>");
            fr.write("\n");
        } catch(Exception e) {
            System.err.println(PRINT_ERR_MSG + "generateDiv");
        }
    }

    /**
     * Main method
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an input file (if none type \'N\'): ");
        String inFilePath = sc.nextLine();
        try {
            // initialize section color map creation if everything works
            addBasicSectionColors();
            if(inFilePath.length() > 1) {
                /**
                 * The user-specified input file for future use. Currently has no utility;
                 * however if appending files merges into project scope, the following 
                 * FileWriter constructors and utility methods will require minor alteration.
                 */
                File inFile = new File(inFilePath);
                BufferedReader br = new BufferedReader(new FileReader(inFile));
                br.close();
            }

            /**
             * Begin output block, using several helper method calls. A new file will be
             * created. Note that the output pathname is not declared: user must specify
             * name and file type.
             */
            System.out.println("Please enter the file destination (including extension): ");
            String outFilePath = sc.nextLine();
            File outFile = new File(outFilePath);
            FileWriter fr = new FileWriter(outFile);
            printHeader(fr);
            fr.write("<body>\n");
            printH1(fr);
            printH2(fr);
            generateDiv(fr);
            printBasicSection(fr, NUM_BASIC_SECTIONS);
            


            fr.write("\t</div>\n");
            fr.write("</body>\n</html>\n");
            fr.close();
            } catch (Exception e) {
                System.err.print("Error, file cannot be read.");
             
        }

        sc.close();
        
    }
}