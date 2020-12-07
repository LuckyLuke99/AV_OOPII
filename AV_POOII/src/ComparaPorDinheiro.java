import java.util.Comparator;

public class ComparaPorDinheiro implements Comparator<Conta>{

	@Override
	public int compare(Conta c1, Conta c2) {
		if (c1.getDinheiro() > c2.getDinheiro())
				return 1;
		else
			if (c1.getDinheiro() < c2.getDinheiro())
				return -1;
			else
				return 0;
	}

}
