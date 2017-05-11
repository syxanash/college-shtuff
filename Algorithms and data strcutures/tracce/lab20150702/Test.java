package lab20150702;

public class Test {
	public static void main(String... args) {
		Referendum europa = new Referendum();
		
		Cittadino[] cittadini = {
				new Cittadino("simone", "marzulli"),
				new Cittadino("morena", "Deliddo"),
				new Cittadino("giovanni", "pizzella"),
				new Cittadino("mimmo", "u nzuvus"),
				new Cittadino("luisa", "tutto"),
				new Cittadino("giovanni", "cappellotto"),
				new Cittadino("simone", "marzulli"),
				new Cittadino("donato", "malerba"),
				new Cittadino("billgates", "bono")
		};
		
		for(Cittadino c : cittadini) {
			europa.addCittadino(c);
		}
		
		europa.apriReferendum();
		
		for(int i = 0; i < cittadini.length; i++) {
			if ( i < (cittadini.length / 2) + 1)
				europa.vota(cittadini[i], Voto.si);
			else 
				europa.vota(cittadini[i], Voto.no);
		}
		
		europa.vota(new Cittadino("pino", "lospazzino"), Voto.no);
		
		System.out.println(europa.votiSI());
		
		for(Cittadino c : europa.votanti()) {
			System.out.println(c.nome + " " + c.cognome);
		}
	}
}
