import java.util.Objects;

public class Performance {
    private String performanceID;
    private String performanceName;
    private String performanceLeadName;
    private char performanceGroup;

    
    public Performance(String performanceID, String performanceName, String performanceLeadName, char performanceGroup) {
        this.performanceID = performanceID;
        this.performanceName = performanceName;
        this.performanceLeadName = performanceLeadName;
        this.performanceGroup = performanceGroup;
    }

  
    public String getPerformanceID() {
        return performanceID;
    }

    public void setPerformanceID(String performanceID) {
        this.performanceID = performanceID;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getPerformanceLeadName() {
        return performanceLeadName;
    }

    public void setPerformanceLeadName(String performanceLeadName) {
        this.performanceLeadName = performanceLeadName;
    }

    public char getPerformanceGroup() {
        return performanceGroup;
    }

    public void setPerformanceGroup(char performanceGroup) {
        this.performanceGroup = performanceGroup;
    }


    @Override
    public String toString() {
        return "Performance{" +
                "performanceID='" + performanceID + '\'' +
                ", performanceName='" + performanceName + '\'' +
                ", performanceLeadName='" + performanceLeadName + '\'' +
                ", performanceGroup='" + performanceGroup + '\'' +
                '}';
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performance that = (Performance) o;
        return Objects.equals(performanceID, that.performanceID) &&
                Objects.equals(performanceName, that.performanceName) &&
                Objects.equals(performanceLeadName, that.performanceLeadName)&&
               Objects.equals(performanceGroup, that.performanceGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(performanceID, performanceName, performanceLeadName, performanceGroup);
    }
}