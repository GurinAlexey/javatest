package com.mycompany;

public class SimpleParser extends ComLineParserBase {
    String inFile;
    String outFile;

    public SimpleParser(String[] keys, String[] delimeters) {
        super(keys, delimeters);
    }


    public String getInFile() {
        return inFile;
    }

    public String getOutFile() {
        return outFile;
    }

    @Override
    public void onUsage(String errorKey) {
        if (errorKey != null)
            System.out.println("Command-line switch error:" + errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    @Override
    public SwitchStatus onSwitch(String key, String keyValue) {
        SwitchStatus status = SwitchStatus.NoError;
        switch (key) {
            case "?":
                status = SwitchStatus.ShowUsage;
                break;
            case "r":
                if (keyValue != null) {
                    inFile = keyValue;
                } else {
                    System.out.println("Ошибка");
                    status = SwitchStatus.Error;
                }
                break;
            case "w":
                if (keyValue != null) {
                    outFile = keyValue;
                } else {
                    System.out.println("Ошибка");
                    status = SwitchStatus.Error;
                }
                break;
        }
        return status;
    }
}
