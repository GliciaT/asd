package Principal;

class Tabuleiro {
	private int[][] gabarito;
	private int[][] grid= new int[9][9];

	public Tabuleiro(){
	  
	}
	
	public boolean executaMovimento(int x, int y, int valor) {
		if(valor<=9 && valor>=1) {
			this.grid[x][y]=valor; 
			return true;
		}
		else return false;
	}
	
	public boolean isTabuleiroPreenchido() {
		for(int i=0;i < this.grid.length;i++) {
			for(int j=0; j < this.grid.length; j++) {
				if (this.grid[i][j]==0) {
					return false;
				}
				
			}
		}
		return true;
	}
	
	public void resolveTabuleiro(){

	}

	public void geraTabuleiro(){
	
	}
        
        public int[][] getGrid(){
            return grid;
        }
}
