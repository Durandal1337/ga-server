package ua.nure.gaserver.json;

public class GraphRequest {
    private Integer chromosomeLength;
    private Integer scale;
    private Double costPer1KmOfCanal;
    private Double costPer1Node;
    private Double mainNodeCost;
    private Double additionalNodeCost;
    private Double[][] coordinates;

    public Double[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double[][] coordinates) {
        this.coordinates = coordinates;
    }

    public Integer getChromosomeLength() {
        return chromosomeLength;
    }

    public void setChromosomeLength(Integer chromosomeLength) {
        this.chromosomeLength = chromosomeLength;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Double getCostPer1KmOfCanal() {
        return costPer1KmOfCanal;
    }

    public void setCostPer1KmOfCanal(Double costPer1KmOfCanal) {
        this.costPer1KmOfCanal = costPer1KmOfCanal;
    }

    public Double getCostPer1Node() {
        return costPer1Node;
    }

    public void setCostPer1Node(Double costPer1Node) {
        this.costPer1Node = costPer1Node;
    }

    public Double getMainNodeCost() {
        return mainNodeCost;
    }

    public void setMainNodeCost(Double mainNodeCost) {
        this.mainNodeCost = mainNodeCost;
    }

    public Double getAdditionalNodeCost() {
        return additionalNodeCost;
    }

    public void setAdditionalNodeCost(Double additionalNodeCost) {
        this.additionalNodeCost = additionalNodeCost;
    }
}
