package com.stackroute.model;

public class Node1 {
    private String node1;
    private String node2;
    private String node3;
    private String node4;

    private String relation1;
    private String relation2;
    private String relation3;
    private String relation4;
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    public Node1()
    {

    }

    public String getNode1() {
        return node1;
    }

    public void setNode1(String node1) {
        this.node1 = node1;
    }

    public String getNode2() {
        return node2;
    }

    public void setNode2(String node2) {
        this.node2 = node2;
    }

    public String getNode3() {
        return node3;
    }

    public void setNode3(String node3) {
        this.node3 = node3;
    }

    public String getNode4() {
        return node4;
    }

    public void setNode4(String node4) {
        this.node4 = node4;
    }

    public String getRelation1() {
        return relation1;
    }

    public void setRelation1(String relation1) {
        this.relation1 = relation1;
    }

    public String getRelation2() {
        return relation2;
    }

    public void setRelation2(String relation2) {
        this.relation2 = relation2;
    }

    public String getRelation3() {
        return relation3;
    }

    public void setRelation3(String relation3) {
        this.relation3 = relation3;
    }

    public String getRelation4() {
        return relation4;
    }

    public void setRelation4(String relation4) {
        this.relation4 = relation4;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public Node1(String node1, String node2, String node3, String node4, String relation1, String relation2, String relation3, String relation4, String value1, String value2, String value3, String value4) {
        this.node1 = node1;
        this.node2 = node2;
        this.node3 = node3;
        this.node4 = node4;
        this.relation1 = relation1;
        this.relation2 = relation2;
        this.relation3 = relation3;
        this.relation4 = relation4;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                ", node3='" + node3 + '\'' +
                ", node4='" + node4 + '\'' +
                ", relation1='" + relation1 + '\'' +
                ", relation2='" + relation2 + '\'' +
                ", relation3='" + relation3 + '\'' +
                ", relation4='" + relation4 + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                '}';
    }
}
