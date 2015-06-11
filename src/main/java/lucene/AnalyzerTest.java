package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AnalyzerTest {

    private static final String[] examples = {"Net income attributable to SunCoke Energy Partners, L.P. subsequent to initial public offering(p)"  };

   /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String[] strings = examples;

        if (args.length > 0) {
            strings = args;
        }
        for (String text : strings) {
            analyze(text);
        }
    }

    public static void analyze(String text) throws IOException {

        System.out.println( getTokens (text) );
    }

    public static List<String> getTokens(String text) throws IOException{
        List<String> tokens = new ArrayList<String>();
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_46);
        TokenStream tokenStream = analyzer.tokenStream("contents", new StringReader(text));
        CharTermAttribute termAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while(tokenStream.incrementToken()){
            tokens.add( termAttribute.toString() );
        }
        return tokens;
    }
}