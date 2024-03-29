package com.example.MathStuff;

public class Term {

    private Operator operator;
    private double coefficient;
    private NumberE e;
    private NaturalLog ln;
    private Cosine[] cos;
    private Sine[] sin;
    private Tangent[] tan;
    private Power pow; //entire term to a power
    // private Integral integ;
    //private Derivative deriv;
    private Variable[] variables;

    public boolean isConstant = false;


    public Term(
        Operator operator,

        double coefficient, 
        
        NumberE e,
        NaturalLog ln,
        Cosine[] cos,
        Sine[] sin,
        Tangent[] tan,
        // Integral integ,
        // Derivative deriv,
        
        Variable... variables){

            this.operator = operator;
            this.coefficient = coefficient;
            this.e = e;
            this.ln = ln;
            this.cos = cos;
            this.sin = sin;
            this.tan = tan;
            // this.integ = integ;
            // this.deriv = deriv;
            this.variables = variables;

    }

    public Term(double coefficient){
        this.coefficient = coefficient;
        this.isConstant = true;
    }

    public Term(double coefficient, Variable... variables){
        this.coefficient = coefficient;
        this.variables = variables;
    }

    public Term(){}

    public class Operator{
            char type;
        public Operator(char c){
            this.type = c;
        }
    }

    //valid operators:
    //e, ln, sin, cos, tan, integral, derivative 

    public class NumberE{
            boolean ifExists;
            public Term power;
        public NumberE(Term p){
            this.power = p;
            this.ifExists = true;
        }

        public NumberE(String na){  //no e in equation, e^0 equals 1
            this.ifExists = false;
        }
    }

    public class NaturalLog{
            boolean ifExists;
            Term power;
            Equation containedEquation;
        public NaturalLog(Term p, Equation t){
            this.power = p;
            this.containedEquation = t;
            this.ifExists = true;
        }

        public NaturalLog(String na){
            this.ifExists = false;
        }
    }

    public class Cosine{
            boolean ifExists;
            int power; //only handles integral powers for trig
            Term containedTerm;
        public Cosine(int p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Cosine(String na){
            this.ifExists = false;
        }
    }

    public class Sine{
            boolean ifExists;
            int power;
            Term containedTerm;
        public Sine(int p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Sine(String na){
            this.ifExists = false;
        }
    }

    public class Tangent{
            boolean ifExists;
            int power;
            Term containedTerm;
        public Tangent(int p, Term t){
            this.power = p;
            this.containedTerm = t;
            this.ifExists = true;
        }

        public Tangent(String na){
            this.ifExists = false;
        }
    }

    public class Power{
            boolean ifExists;
            Term degree;
        public Power(Term degree){
            this.degree = degree;
            this.ifExists = true;
        }

        public Power(String na){
            this.ifExists = false;
        }
    }

    // public class Integral{
    //         boolean ifExists;
    //         char axisOfIntegration;
    //         double upperLimit;
    //         double lowerLimit;
    //     public Integral(char c){  //indefinite integral
    //         this.axisOfIntegration = c;
    //         this.ifExists = true;
    //     }

    //     public Integral(char c, double upper, double lower){  //definite integral
    //         this.axisOfIntegration = c;
    //         this.upperLimit = upper;
    //         this.lowerLimit = lower;
    //         this.ifExists = false;
    //     }

    //     public Integral(String na){
    //         this.ifExists = false;
    //     }
    // }

    // public class Derivative{  //appears as (d/dx) and so on
    //         boolean ifExists;
    //         char axisOfDerivation;
    //         boolean ifPartial;
    //     public Derivative(char c, boolean b){
    //         this.axisOfDerivation = c;
    //         this.ifPartial = b;
    //         this.ifExists = true;
    //     }

    //     public Derivative(){
    //         this.ifExists = false;
    //     }
    // }

    public class Variable{
            boolean ifExists;
            char variableName;
            Term power;
        public Variable(char c, Term p){
            this.variableName = c;
            this.power = p;
            this.ifExists = true;
        }

        public Variable(String na){
            this.ifExists = false;
        }
    }

    //getters for different components of term
    public Operator getOperator(){
        return this.operator;
    }

    public double getCoefficient(){
        return this.coefficient;
    }

    public NumberE getNumberE(){
        return this.e;
    }

    public NaturalLog getNaturalLog(){
        return this.ln;
    }

    public Cosine[] getCosine(){
        return this.cos;
    }

    public Sine[] getSine(){
        return this.sin;
    }

    public Tangent[] getTangent(){
        return this.tan;
    }

    // public Integral getIntegral(){
    //     return this.integ;
    // }

    // public Derivative getDerivative(){
    //     return this.deriv;
    // }

    public Variable getVariable(int index){
        if(index > variables.length){
            return new Variable("na");
        }else{
            return variables[index];
        }
    }

    public Variable[] getVariables(){
        return this.variables;
    }

    //setters

    public void setCoefficient(double a){
        this.coefficient = a;
    }

    public void setNumberE(NumberE a){
        this.e = a;
    }

    public void setNaturalLog(NaturalLog a){
        this.ln = a;
    }

    public void setCosine(Cosine a, int index){
        this.cos[index] = a;
    }

    public void setSine(Sine a, int index){
        this.sin[index] = a;
    }

    public void setTangent(Tangent a, int index){
        this.tan[index] = a;
    }

    public void addVariable(Variable v){
        Variable[] newVariables = new Variable[variables.length + 1];
        for(int i=0; i<variables.length; i++){
            newVariables[i] = variables[i];
        }
        newVariables[variables.length+1] = v;
        this.variables = newVariables;
    }

    public int findVariable(char name){
        for(int i=0; i<variables.length; i++){
            if(variables[i].variableName == name){
                return i;
            }
        }
        addVariable(new Variable(name, new Term(0)));
        return variables.length;
    }

}
