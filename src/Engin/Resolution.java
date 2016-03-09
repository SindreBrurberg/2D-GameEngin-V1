package Engin;

/**
 * Created by sbrurberg on 3/8/2016.
 * Resolution, i might use this ass a constant for every page but not shure, thik ill delite this one.
 */
public enum Resolution {
	WIDTH (800, 1280, 1600),
	WIDTH_OFFSET (6),
	HEIGHT (600, 720, 900),
	HEIGHT_OFFSET (27);

	private final Integer resolution600P;
	private final Integer resolution720P;
	private final Integer resolution900P;
	private final Integer offset;

	Resolution (int offset) {
		this.offset = offset;
		this.resolution600P = null;
		this.resolution720P = null;
		this.resolution900P = null;
	}

	Resolution (int resolution600P, int resolution720P, int resolution900P) {
		this.resolution600P = resolution600P;
		this.resolution720P = resolution720P;
		this.resolution900P = resolution900P;
		this.offset = null;
	}

	private Integer resolution600P() {return resolution600P;}
	private Integer resolution720P() {return resolution720P;}
	private Integer resolution900P() {return resolution900P;}
	private Integer offset() {return offset;}
}
