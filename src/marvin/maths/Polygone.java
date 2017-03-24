package marvin.maths;

import java.util.ArrayList;
import marvin.maths.impl.FloatVecteur;
import marvin.maths.impl.Polyedre;

public abstract class Polygone extends Polyedre {

    public Polygone(FloatVecteur o, FloatVecteur... v) {
        super(o, v);
    }

    public Polygone(FloatVecteur o, ArrayList<FloatVecteur> v) {
        super(o, (FloatVecteur[]) v.toArray());
    }

}
