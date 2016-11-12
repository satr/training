package io.github.satr.training.tests;

import io.github.satr.training.datastructures.BTNodeEx;

public abstract class TreeTestBase {

    private BTNodeEx n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14;

    public BTNodeEx n1() {
        return n1 != null ? n1 : (n1 = new BTNodeEx(1));
    }

    public BTNodeEx n2() {
        return n2 != null ? n2 : (n2 = new BTNodeEx(2));
    }

    public BTNodeEx n3() {
        return n3 != null ? n3 : (n3 = new BTNodeEx(3));
    }

    public BTNodeEx n4() {
        return n4 != null ? n4 : (n4 = new BTNodeEx(4));
    }

    public BTNodeEx n5() {
        return n5 != null ? n5 : (n5 = new BTNodeEx(5));
    }

    public BTNodeEx n6() {
        return n6 != null ? n6 : (n6 = new BTNodeEx(6));
    }

    public BTNodeEx n7() {
        return n7 != null ? n7 : (n7 = new BTNodeEx(7));
    }

    public BTNodeEx n8() {
        return n8 != null ? n8 : (n8 = new BTNodeEx(8));
    }

    public BTNodeEx n9() {
        return n9 != null ? n9 : (n9 = new BTNodeEx(9));
    }
    public BTNodeEx n10() {
        return n10 != null ? n10 : (n10 = new BTNodeEx(10));
    }
    public BTNodeEx n11() {
        return n11 != null ? n11 : (n11 = new BTNodeEx(11));
    }
    public BTNodeEx n12() {
        return n12 != null ? n12 : (n12 = new BTNodeEx(12));
    }
    public BTNodeEx n13() {
        return n13 != null ? n13 : (n13 = new BTNodeEx(13));
    }
    public BTNodeEx n14() {
        return n14 != null ? n14 : (n14 = new BTNodeEx(14));
    }
}
