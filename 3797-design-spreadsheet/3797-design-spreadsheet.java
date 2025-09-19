class Spreadsheet {
    private Map<String, Integer> cellMap;//declare map

    public Spreadsheet(int rows) {
        cellMap = new HashMap<>();
        
    }
    
    public void setCell(String cell, int value) {
        cellMap.put(cell, value);
        
    }
    
    public void resetCell(String cell) {
        cellMap.remove(cell);
        
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1); // remove'='
        String[] parts = formula.split("\\+");
        return getTermValue(parts[0]) + getTermValue(parts[1]);
        
    }

    //Helper: return term value(cell reference or number)
    private int getTermValue(String term){
        if(Character.isDigit(term.charAt(0))){
            return Integer.parseInt(term); // its a number
        }
        return cellMap.getOrDefault(term, 0);//default 0 if unset
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */