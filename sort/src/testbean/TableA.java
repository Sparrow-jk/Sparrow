package testbean;

import java.util.List;

/**
 * @author chansiwan
 * @since 2021-04-30 11:17
 */

public class TableA {

    public TableA(TableC tableC, String testColumn1, int testColumn2, List<TableD> tableList) {
        this.tableC = tableC;
        this.testColumn1 = testColumn1;
        this.testColumn2 = testColumn2;
        this.tableList = tableList;
    }

    private TableC tableC;

    private String testColumn1;

    private int testColumn2;

    private List<TableD> tableList;

    public String getTestColumn1() {
        return testColumn1;
    }

    public void setTestColumn1(String testColumn1) {
        this.testColumn1 = testColumn1;
    }

    public int getTestColumn2() {
        return testColumn2;
    }

    public void setTestColumn2(int testColumn2) {
        this.testColumn2 = testColumn2;
    }

    public TableC getTableC() {
        return tableC;
    }

    public void setTableC(TableC tableC) {
        this.tableC = tableC;
    }

    public List<TableD> getTableList() {
        return tableList;
    }

    public void setTableList(List<TableD> tableList) {
        this.tableList = tableList;
    }
}
