package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$parse_tokens2'/7</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$parse_tokens2_7 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("operator");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("expected");
    static SymbolTerm s3 = SymbolTerm.makeSymbol("after");
    static SymbolTerm s4 = SymbolTerm.makeSymbol("expression");
    static SymbolTerm s5 = SymbolTerm.makeSymbol("[]");
    static ListTerm s6 = new ListTerm(s4, s5);
    static ListTerm s7 = new ListTerm(s3, s6);
    static ListTerm s8 = new ListTerm(s2, s7);
    static ListTerm s9 = new ListTerm(s1, s8);
    static Predicate _$parse_tokens2_7_sub_1 = new PRED_$parse_tokens2_7_sub_1();
    static Predicate _$parse_tokens2_7_sub_2 = new PRED_$parse_tokens2_7_sub_2();
    static Predicate _$parse_tokens2_7_1 = new PRED_$parse_tokens2_7_1();
    static Predicate _$parse_tokens2_7_2 = new PRED_$parse_tokens2_7_2();
    static Predicate _$parse_tokens2_7_3 = new PRED_$parse_tokens2_7_3();

    public Term arg1, arg2, arg3, arg4, arg5, arg6, arg7;

    public PRED_$parse_tokens2_7(Term a1, Term a2, Term a3, Term a4, Term a5, Term a6, Term a7, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        arg5 = a5;
        arg6 = a6;
        arg7 = a7;
        this.cont = cont;
    }

    public PRED_$parse_tokens2_7(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        arg5 = args[4];
        arg6 = args[5];
        arg7 = args[6];
        this.cont = cont;
    }

    public int arity() { return 7; }

    public String toString() {
        return "$parse_tokens2(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + arg5 + "," + arg6 + "," + arg7 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.aregs[5] = arg5;
        engine.aregs[6] = arg6;
        engine.aregs[7] = arg7;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$parse_tokens2_7_1, _$parse_tokens2_7_sub_1);
    }
}

class PRED_$parse_tokens2_7_sub_1 extends PRED_$parse_tokens2_7 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$parse_tokens2_7_2, _$parse_tokens2_7_sub_2);
    }
}

class PRED_$parse_tokens2_7_sub_2 extends PRED_$parse_tokens2_7 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$parse_tokens2_7_3);
    }
}

class PRED_$parse_tokens2_7_1 extends PRED_$parse_tokens2_7 {
    public Predicate exec(Prolog engine) {
    // '$parse_tokens2'(A,B,C,B,C,D,E):-'$parse_tokens_peep_next'(F,D,E),'$parse_tokens_is_terminator'(F),C=<A,!
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9;
        Predicate p1, p2, p3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        a6 = engine.aregs[6];
        a7 = engine.aregs[7];
        cont = engine.cont;
    // '$parse_tokens2'(A,B,C,B,C,D,E):-['$get_level'(F),'$parse_tokens_peep_next'(G,D,E),'$parse_tokens_is_terminator'(G),'$less_or_equal'(C,A),'$cut'(F)]
        if (! a2.unify(a4, engine.trail))
            return engine.fail();
        if (! a3.unify(a5, engine.trail))
            return engine.fail();
        a8 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(8))
        if (! a8.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        a9 = new VariableTerm(engine);
        p1 = new PRED_$cut_1(a8, cont);
        p2 = new PRED_$less_or_equal_2(a3, a1, p1);
        p3 = new PRED_$parse_tokens_is_terminator_1(a9, p2);
        return new PRED_$parse_tokens_peep_next_3(a9, a6, a7, p3);
    }
}

class PRED_$parse_tokens2_7_2 extends PRED_$parse_tokens2_7 {
    public Predicate exec(Prolog engine) {
    // '$parse_tokens2'(A,B,C,D,E,F,G):-'$parse_tokens_peep_next'(H,F,I),'$parse_tokens_is_post_in_op'(H),!,'$parse_tokens_post_in_ops'(A,B,C,D,E,I,G)
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
        Predicate p1, p2, p3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        a6 = engine.aregs[6];
        a7 = engine.aregs[7];
        cont = engine.cont;
    // '$parse_tokens2'(A,B,C,D,E,F,G):-['$get_level'(H),'$parse_tokens_peep_next'(I,F,J),'$parse_tokens_is_post_in_op'(I),'$cut'(H),'$parse_tokens_post_in_ops'(A,B,C,D,E,J,G)]
        a8 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(8))
        if (! a8.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        a9 = new VariableTerm(engine);
        a10 = new VariableTerm(engine);
        p1 = new PRED_$parse_tokens_post_in_ops_7(a1, a2, a3, a4, a5, a10, a7, cont);
        p2 = new PRED_$cut_1(a8, p1);
        p3 = new PRED_$parse_tokens_is_post_in_op_1(a9, p2);
        return new PRED_$parse_tokens_peep_next_3(a9, a6, a10, p3);
    }
}

class PRED_$parse_tokens2_7_3 extends PRED_$parse_tokens2_7 {
    public Predicate exec(Prolog engine) {
    // '$parse_tokens2'(A,B,C,D,E,F,G):-'$parse_tokens_error'([operator,expected,after,expression],F,G)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        a6 = engine.aregs[6];
        a7 = engine.aregs[7];
        cont = engine.cont;
    // '$parse_tokens2'(A,B,C,D,E,F,G):-['$parse_tokens_error'([operator,expected,after,expression],F,G)]
        return new PRED_$parse_tokens_error_3(s9, a6, a7, cont);
    }
}