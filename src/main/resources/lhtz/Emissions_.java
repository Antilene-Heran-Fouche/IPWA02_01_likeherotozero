package lhtz;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-11-21T15:12:18.069+0100")
@StaticMetamodel(Emissions.class)
public class Emissions_ {
	public static volatile SingularAttribute<Emissions, Integer> id;
	public static volatile SingularAttribute<Emissions, Integer> year;
	public static volatile SingularAttribute<Emissions, Long> population;
	public static volatile SingularAttribute<Emissions, Double> gdp;
	public static volatile SingularAttribute<Emissions, Double> co2;
	public static volatile SingularAttribute<Emissions, Double> co2_including_luc;
	public static volatile SingularAttribute<Emissions, Double> co2_per_capita;
}
