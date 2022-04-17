package src.utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.io.Console;

public class Utils {
    public static final Random RandomGenerator = new Random();
    public static final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    public static final String NEW_LINE = System.getProperty("line.separator");
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public Utils() throws IOException {
    }
    
}