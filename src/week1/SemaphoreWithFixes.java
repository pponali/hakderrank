package week1;

/**
 * @author prakashponali
 * @Date 24/10/23
 */
public class SemaphoreWithFixes {
    private Object _mutex = new Object();
    private int _currAvail;

    public SemaphoreWithFixes(int capacity)
    {
        _currAvail = capacity;
    }

    /*public void Wait()
    {
        lock (_mutex)
        {
            while (_currAvail == 0)
            {
                Monitor.Wait(_mutex);
            }
            _currAvail--;
        }
    }

    public bool Wait(int millisecondsTimeout)
    {
        lock (_mutex)
        {
            while (_currAvail == 0)
            {
                if (!Monitor.Wait(_mutex, millisecondsTimeout))
                    return false; // Timeout
            }
            _currAvail--;
            return true;
        }
    }

    public void Signal()
    {
        lock (_mutex)
        {
            _currAvail++;
            Monitor.Pulse(_mutex);
        }
    }*/
}
