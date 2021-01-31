package task7ServerClient2Continue;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private double value;
    private String unit;
    private long unitType;

    public Item() {
    }

    @JsonProperty("Value")
    public double getValue() { return value; }
    @JsonProperty("Value")
    public void setValue(double value) { this.value = value; }

    @JsonProperty("Unit")
    public String getUnit() { return unit; }
    @JsonProperty("Unit")
    public void setUnit(String value) { this.unit = value; }

    @JsonProperty("UnitType")
    public long getUnitType() { return unitType; }
    @JsonProperty("UnitType")
    public void setUnitType(long value) { this.unitType = value; }

}
