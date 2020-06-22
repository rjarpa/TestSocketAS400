
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		PortScannerDomino oPS= new PortScannerDomino();
		//System.out.println("oPS: "+oPS.testPort(80, "10.111.16.242"));
		System.out.println("oPS: "+oPS.testPort(8471, "10.111.16.237"));
		System.out.println("oPS: "+oPS.testPort(8471, "ATCOCHL"));
		System.out.println("oPS: "+oPS.testPort(8476, "10.111.16.237"));
		System.out.println("oPS: "+oPS.testPort(1433, "10.111.16.221"));
		System.out.println("oPS: "+oPS.testPort(1433, "10.111.16.226"));
		System.out.println("oPS: "+oPS.testPort(1433, "10.111.16.245"));
		
		
		//System.out.println()
		
		
	}

}
