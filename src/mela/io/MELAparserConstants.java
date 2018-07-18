/* Generated By:JavaCC: Do not edit this line. MELAparserConstants.java */
package mela.io;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface MELAparserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int INTEGER = 7;
  /** RegularExpression Id. */
  int FLOAT = 8;
  /** RegularExpression Id. */
  int FLOAT_SCIENTIFIC = 9;
  /** RegularExpression Id. */
  int EXPONENT = 10;
  /** RegularExpression Id. */
  int LETTER = 11;
  /** RegularExpression Id. */
  int DIGIT = 12;
  /** RegularExpression Id. */
  int WORD = 13;
  /** RegularExpression Id. */
  int SECTION_SPACE = 14;
  /** RegularExpression Id. */
  int SECTION_PARAM = 15;
  /** RegularExpression Id. */
  int SECTION_AGENTS = 16;
  /** RegularExpression Id. */
  int SECTION_ENV = 17;
  /** RegularExpression Id. */
  int SECTION_INIT = 18;
  /** RegularExpression Id. */
  int VERTICES = 19;
  /** RegularExpression Id. */
  int EDGES = 20;
  /** RegularExpression Id. */
  int KEYWORD_GRAPH = 21;
  /** RegularExpression Id. */
  int KEYWORD_ONED = 22;
  /** RegularExpression Id. */
  int KEYWORD_TWOD = 23;
  /** RegularExpression Id. */
  int KEYWORD_THREED = 24;
  /** RegularExpression Id. */
  int KEYWORD_LOC = 25;
  /** RegularExpression Id. */
  int KEYWORD_NEIGH = 26;
  /** RegularExpression Id. */
  int KEYWORD_ALL = 27;
  /** RegularExpression Id. */
  int EOL = 28;
  /** RegularExpression Id. */
  int PLUS = 29;
  /** RegularExpression Id. */
  int DOT = 30;
  /** RegularExpression Id. */
  int SEMICOLON = 31;
  /** RegularExpression Id. */
  int DEFINE = 32;
  /** RegularExpression Id. */
  int ASSIGN = 33;
  /** RegularExpression Id. */
  int LSQ = 34;
  /** RegularExpression Id. */
  int RSQ = 35;
  /** RegularExpression Id. */
  int LR = 36;
  /** RegularExpression Id. */
  int RR = 37;
  /** RegularExpression Id. */
  int QUO = 38;
  /** RegularExpression Id. */
  int SQUO = 39;
  /** RegularExpression Id. */
  int EXCL = 40;
  /** RegularExpression Id. */
  int LBRAC = 41;
  /** RegularExpression Id. */
  int RBRAC = 42;
  /** RegularExpression Id. */
  int COMMA = 43;
  /** RegularExpression Id. */
  int LANG = 44;
  /** RegularExpression Id. */
  int RANG = 45;
  /** RegularExpression Id. */
  int PARALLEL = 46;
  /** RegularExpression Id. */
  int TRIANGLE = 47;
  /** RegularExpression Id. */
  int DASH = 48;
  /** RegularExpression Id. */
  int UP = 49;
  /** RegularExpression Id. */
  int DOWN = 50;
  /** RegularExpression Id. */
  int INT = 51;
  /** RegularExpression Id. */
  int DOUBLE = 52;
  /** RegularExpression Id. */
  int IDENTIFIER = 53;
  /** RegularExpression Id. */
  int MATH_EXPR = 54;
  /** RegularExpression Id. */
  int SPACE = 55;
  /** RegularExpression Id. */
  int M_AND = 56;
  /** RegularExpression Id. */
  int M_OR = 57;
  /** RegularExpression Id. */
  int M_LINER = 58;
  /** RegularExpression Id. */
  int M_LINEN = 59;
  /** RegularExpression Id. */
  int SYMBOL = 60;
  /** RegularExpression Id. */
  int PARAM_SYMBOL = 61;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int RESET = 1;
  /** Lexical state. */
  int ID = 2;
  /** Lexical state. */
  int MATH = 3;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<token of kind 5>",
    "<token of kind 6>",
    "<INTEGER>",
    "<FLOAT>",
    "<FLOAT_SCIENTIFIC>",
    "<EXPONENT>",
    "<LETTER>",
    "<DIGIT>",
    "<WORD>",
    "\"#Space\"",
    "\"#Parameters\"",
    "\"#Agents\"",
    "\"#Environment\"",
    "\"#Initial conditions\"",
    "\"L\"",
    "\"E\"",
    "\"Graph\"",
    "\"OneD\"",
    "\"TwoD\"",
    "\"ThreeD\"",
    "\"l\"",
    "\"N\"",
    "\"all\"",
    "\";\"",
    "\"+\"",
    "\".\"",
    "\":\"",
    "\":=\"",
    "\"=\"",
    "\"[\"",
    "\"]\"",
    "\"(\"",
    "\")\"",
    "\"\\\"\"",
    "\"\\\'\"",
    "\"!\"",
    "\"{\"",
    "\"}\"",
    "\",\"",
    "\"<\"",
    "\">\"",
    "\"||\"",
    "\"|>\"",
    "\"-\"",
    "\">>\"",
    "\"<<\"",
    "<INT>",
    "<DOUBLE>",
    "<IDENTIFIER>",
    "<MATH_EXPR>",
    "<SPACE>",
    "\"&&\"",
    "\"|\"",
    "\"\\r\"",
    "\"\\n\"",
    "<SYMBOL>",
    "<PARAM_SYMBOL>",
  };

}
