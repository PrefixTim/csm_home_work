package lab17.character;

import java.util.Arrays;

/**
 * Not efficient but fun. it's existence is error. it need to be redune as a n th matrix or tensor
 *
 * @since 1, 12/7/2019 00:13 am
 */
public class Vector {
    private double[] max;
    private double[] min;
    private double[] v;

    public Vector(double[] v) {
        this.v = v;
    }

    public Vector(double element, int length) {
        this.v = new double[length];
        Arrays.fill(this.v, element);
    }

    /**
     * @param a first additive
     * @param b second additive
     * @return sum of two vectors
     */
    public static Vector add(Vector a, Vector b) {
        return a.clone().add(b);
    }

    /**
     * @param a Minuend
     * @param b subtrahend
     * @return difference of two vectors
     */
    public static Vector sub(Vector a, Vector b) {
        return a.clone().sub(b);
    }

    /**
     * @param a first multiple
     * @param b second multiple
     * @return multiplication of two vectors
     */
    public static Vector mul(Vector a, Vector b) {
        return a.clone().mul(b);
    }

    /**
     * @param a divisible
     * @param b divider
     * @return division of two vectors
     */
    public static Vector div(Vector a, Vector b) {
        return a.clone().div(b);
    }

    /**
     * @param a first additive
     * @param b second additive
     * @return sum of two vectors
     */
    public static Vector add(Vector a, double b) {
        return a.clone().add(b);
    }

    /**
     * @param a Minuend
     * @param b subtrahend
     * @return difference of two vectors
     */
    public static Vector sub(Vector a, double b) {
        return a.clone().sub(b);
    }

    /**
     * @param a first multiple
     * @param b second multiple
     * @return multiplication of two vectors
     */
    public static Vector mul(Vector a, double b) {
        return a.clone().mul(b);
    }

    /**
     * @param a divisible
     * @param b divider
     * @return division of two vectors
     */
    public static Vector div(Vector a, double b) {
        return a.clone().div(b);
    }

    public static Vector cross(Vector a, Vector b) {
        //:TODO
        return a;
    }

    public Vector copy(Vector vector) {
        this.v = Arrays.copyOf(vector.v, vector.v.length);
        this.max = Arrays.copyOf(vector.max, vector.max.length);
        this.min = Arrays.copyOf(vector.min, vector.min.length);
        return this;
    }

    @Override
    protected Vector clone() {
        Vector clone = new Vector(Arrays.copyOf(v, v.length));
        if (max != null)
            clone.setMax(Arrays.copyOf(max, max.length));
        if (min != null)
            clone.setMin(Arrays.copyOf(min, min.length));
        return clone;
    }

    public Vector translate(Vector trans, double k, boolean sign) {
        if (sign) {
            this.add(Vector.mul(trans, k));
        } else {
            this.sub(Vector.mul(trans, k));
        }
        return this;
    }

    public Vector approach(Vector goal, Vector speed, double k) {
        if (!(this.size() == goal.size() && goal.size() == speed.size()))
            throw new IllegalArgumentException("this, goal, speed vector's sizes must match");
        Vector dif = Vector.sub(goal, this);
        for (int i = 0; i < size(); i++) {
            if (dif.get(i) > speed.get(i)) {
                this.set(i, this.get(i) + k * speed.get(i));
            } else if (-dif.get(i) > speed.get(i)) {
                this.set(i, this.get(i) - k * speed.get(i));
            } else {
                this.set(i, goal.get(i));
            }
            keepWithBoarders(i);
        }
        return this;
    }

    private void approach(double goal, double speed, int i) {

    }

    public int size() {
        return v.length;
    }

    /**
     * Change state of vector. DO NOT CREATES A NEW VECTOR
     *
     * @param add vector to add to this vector
     * @return itself
     */
    public Vector add(Vector add) {
        return add(add, true);
    }

    /**
     * Change state of vector. DO NOT CREATES A NEW VECTOR
     *
     * @param sub vector to add to this vector
     * @return itself
     */
    public Vector sub(Vector sub) {
        return add(sub, false);
    }

    private Vector add(Vector add, boolean sign) {
        for (int i = 0; i < this.size(); i++) {
            v[i] += sign ? add.get(i % add.size()) : -add.get(i % add.size());
            keepWithBoarders(i);
        }
        return this;
    }

    /**
     * Change state of vector. DO NOT CREATES A NEW VECTOR
     *
     * @param mul vector to multiply on this vector
     * @return itself
     */
    public Vector mul(Vector mul) {
        return mul(mul, true);
    }

    /**
     * Change state of vector. DO NOT CREATES A NEW VECTOR
     *
     * @param div vector to dived this vector
     * @return itself
     */
    public Vector div(Vector div) {
        return mul(div, false);
    }

    private Vector mul(Vector add, boolean sign) {
        for (int i = 0; i < this.size(); i++) {
            if (sign) v[i] *= add.get(i % add.size());
            else v[i] /= add.get(i % add.size());
            keepWithBoarders(i);
        }
        return this;
    }

    private Vector cross(Vector vector) {
        //:TODO
        return this;
    }

    /**
     * Change state of vector. DO NOT CREATES A NEW VECTOR
     *
     * @param add number to add to this vector
     * @return itself
     */
    public Vector add(double add) {
        return add(add, true);
    }

    /**
     * Change state of vector. DO NOT CREATES A NEW VECTOR
     *
     * @param sub number to add to this vector
     * @return itself
     */
    public Vector sub(double sub) {
        return add(sub, false);
    }

    private Vector add(double add, boolean sign) {
        for (int i = 0; i < this.size(); i++) {
            v[i] += sign ? add : -add;
            keepWithBoarders(i);
        }
        return this;
    }

    /**
     * Change state of vector. DO NOT CREATES A NEW VECTOR
     *
     * @param mul number to multiply on this vector
     * @return itself
     */
    public Vector mul(double mul) {
        return mul(mul, true);
    }

    /**
     * Change state of vector. DO NOT CREATES A NEW VECTOR
     *
     * @param div number to dived this vector
     * @return itself
     */
    public Vector div(double div) {
        return mul(div, false);
    }

    private Vector mul(double add, boolean sign) {
        for (int i = 0; i < this.size(); i++) {
            if (sign) v[i] *= add;
            else v[i] /= add;
            keepWithBoarders(i);
        }
        return this;
    }

    public void keepWithBoarders(int i) {
        if (max != null && v[i] > max[i])
            v[i] = max[i];
        else if (min != null && v[i] < min[i])
            v[i] = min[i];
    }

    /**
     * get i th element
     *
     * @param i index of element
     * @return elemebt of index i
     */
    public double get(int i) {
        if (i < v.length) {
            return v[i];
        } else {
            throw new IllegalArgumentException("index out of bound");
        }
    }

    /**
     * set i th element
     *
     * @param i index of element
     */
    public void set(int i, double val) {
        if (i < v.length) {
            v[i] = val;
        } else {
            throw new IllegalArgumentException("index out of bound");
        }
    }

    public double[] getMin() {
        return min;
    }

    public void setMin(double[] min) {
        this.min = min;
    }

    public double[] getMax() {
        return max;
    }

    public void setMax(double[] max) {
        this.max = max;
    }
}
