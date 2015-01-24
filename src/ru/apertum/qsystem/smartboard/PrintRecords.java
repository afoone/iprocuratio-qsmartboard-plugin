/*
 * Copyright (C) 2015 Evgeniy Egorov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ru.apertum.qsystem.smartboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Properties;
import ru.apertum.qsystem.server.controller.AIndicatorBoard;

/**
 *
 * @author Evgeniy Egorov
 */
public class PrintRecords {

    String topSize = "0px";
    String topUrl = "";
    String leftSize = "0px";
    String leftUrl = "";
    String rightSize = "0px";
    String rightUrl = "";
    String bottomSize = "0px";
    String bottomUrl = "";

    String columnFirst = "Clients column";
    String columnSecond = "To point";
    String columnExt = "Ext column";

    public String getTopSize() {
        return topSize;
    }

    public String getTopUrl() {
        return topUrl;
    }

    public String getLeftSize() {
        return leftSize;
    }

    public String getLeftUrl() {
        return leftUrl;
    }

    public String getRightSize() {
        return rightSize;
    }

    public String getRightUrl() {
        return rightUrl;
    }

    public String getBottomSize() {
        return bottomSize;
    }

    public String getBottomUrl() {
        return bottomUrl;
    }

    public String getColumnFirst() {
        return columnFirst;
    }

    public String getColumnSecond() {
        return columnSecond;
    }

    public String getColumnExt() {
        return columnExt;
    }

    private PrintRecords() {
        File f = new File("config/QSmartboardPlugin.properties");
        if (f.exists()) {
            final FileInputStream inStream;
            try {
                inStream = new FileInputStream(f);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            final Properties settings = new Properties();
            try {
                settings.load(new InputStreamReader(inStream, "UTF-8"));
            } catch (IOException ex) {
                throw new RuntimeException("Cant read version. " + ex);
            }

            topSize = settings.getProperty("top.size").matches("^-?\\d+(%|px)$") ? settings.getProperty("top.size") : "0px";
            topUrl = settings.getProperty("top.url");
            leftSize = settings.getProperty("left.size").matches("^-?\\d+(%|px)$") ? settings.getProperty("left.size") : "0px";
            leftUrl = settings.getProperty("left.url");
            rightSize = settings.getProperty("right.size").matches("^-?\\d+(%|px)$") ? settings.getProperty("right.size") : "0px";
            rightUrl = settings.getProperty("right.url");
            bottomSize = settings.getProperty("bottom.size").matches("^-?\\d+(%|px)$") ? settings.getProperty("bottom.size") : "0px";
            bottomUrl = settings.getProperty("bottom.url");

            columnFirst = settings.getProperty("column.first");
            columnSecond = settings.getProperty("column.second");
            columnExt = settings.getProperty("column.ext");

        }
    }

    public static PrintRecords getInstance() {
        return PrintRecordsHolder.INSTANCE;
    }

    private static class PrintRecordsHolder {

        private static final PrintRecords INSTANCE = new PrintRecords();
    }

    private LinkedHashSet<AIndicatorBoard.Record> records = new LinkedHashSet<>();

    public LinkedHashSet<AIndicatorBoard.Record> getRecords() {
        return records;
    }

    public void setRecords(LinkedHashSet<AIndicatorBoard.Record> records) {
        this.records = records;
    }
    
    private boolean invited;

    public boolean isInvited() {
        return invited;
    }

    public void setInvited(boolean invited) {
        this.invited = invited;
    }
    

}
