package com.dynatrace.loadrunner;

import com.dynatrace.loadrunner.data.ScriptFile;
import com.dynatrace.loadrunner.logic.LoadRunnerConverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static void printUsage() {
        System.out.println("Usage: 'convert -m insert|remove [-h hfile1.h hfile2.h ...] [-c cfile1.c cfile2.c ...]");
    }

    public static void main(String[] args) {
        if (args == null || args.length < 4 || !args[0].equals("-m")) {
            printUsage();
            return;
        }

        boolean mode = args[1].equals("insert");
        if (!mode && !args[1].equals("remove")) {
            printUsage();
            return;
        }

        List<ScriptFile> hFiles = null;
        List<ScriptFile> cFiles = null;

        List<ScriptFile> currentFileList = null;
        for (int i = 2; i < args.length; i++) {
            if (args[i].equals("-h")) {
                hFiles = new ArrayList<>();
                currentFileList = hFiles;
            } else if (args[i].equals("-c")) {
                cFiles = new ArrayList<>();
                currentFileList = cFiles;
            } else if (currentFileList != null) {
                File file = new File(args[i]);
                if (!file.exists()) {
                    System.out.println("Could not load " + args[i]);
                    return;
                }
                currentFileList.add(new ScriptFile(file));
            } else {
                printUsage();
                return;
            }
        }

        System.out.println("Mode: " + mode);

        LoadRunnerConverter converter = new LoadRunnerConverter();
        converter.configureConverter(mode, hFiles, cFiles);
        converter.convertFiles();
    }
}
