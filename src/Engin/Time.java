package Engin;

/**
 * Created by Dethsanius on 06.04.2014, project is GameEngin-V1 package are Engin.
 */
public class Time {
    private int houer, minute, secound;

    public Time()
    {
        this(0, 0, 0);
    }

    public Time(int h)
    {
        this(h, 0, 0);
    }

    public Time(int h, int m)
    {
        this(h, m, 0);
    }

    public Time(int h, int m, int s)
    {
        setTime(h, m, s);
    }

    public void setTime(int h, int m, int s)
    {
        setHouer(h);
        setMinute(m);
        setSecound(s);
    }

    public int getHouer()
    {
        return houer;
    }

    public void setHouer(int h)
    {
        houer = ((h >= 0 && h < 24) ? h : 0);
    }

    public int getMinute()
    {
        return minute;
    }

    public void setMinute(int m)
    {
        minute = ((m >= 0 && m < 60) ? m : 0);
    }

    public int getSecound()
    {
        return secound;
    }

    public void setSecound(int s)
    {
        secound = ((s >= 0 && s < 60) ? s : 0);
    }

    public String toMilitary()
    {
        return String.format("%02d:%02d:%02d", getHouer(), getMinute(), getSecound());
    }

    public String toUSStandard()
    {
        return String.format("%d:%02d:%02d %s", ((getHouer() == 0 || getHouer() == 12) ? 12 : getHouer()), getMinute(), getSecound(), ((getHouer() < 12) ? "AM" : "PM"));
    }
}
