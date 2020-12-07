import java.util.Comparator;

public class ComparaPorEspaco implements Comparator<Conta>{

	@Override
	public int compare(Conta c1, Conta c2) {
		if (c1.getEspaco() > c2.getEspaco())
				return 1;
		else
			if (c1.getEspaco() < c2.getEspaco())
				return -1;
			else
				return 0;
	}

}
