import java.util.Comparator;

public class ComparaPorNome implements Comparator<Conta>{

	@Override
	public int compare(Conta c1, Conta c2) {
		return c1.getLogin().compareTo(c2.getLogin());
	}
}
