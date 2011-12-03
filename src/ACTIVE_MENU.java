public enum ACTIVE_MENU {
		    PEOPLE(0),
		    CARS(1),
		    TICKETS(2),
		    FIND_CAR(3);
		    
		    private final int index;
		    ACTIVE_MENU(int index) {
		      this.index = index;
		    }	
		    
		    //get
		    int g(){
		    	return index;
		    }		  
	}