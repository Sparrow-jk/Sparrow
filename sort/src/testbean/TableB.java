package testbean;

import java.util.List;

/**
 * @author chansiwan
 * @since 2021-04-30 11:17
 */
public class TableB {

    private TableC tableC;

    private String testColumn1;

    private int testColumn2;

    private List<TableE> tableList;

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

    public List<TableE> getTableList() {
        return tableList;
    }

    public void setTableList(List<TableE> tableList) {
        this.tableList = tableList;
    }
}
