using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csFileCabinets.Structs.Arrays
{
    public class DoubleArray : BaseNode
    {
        private List<double> nValue;

        public List<double> NValue { get => nValue; set => nValue = value; }

        public DoubleArray() { }

        public DoubleArray(string k, double v) : base(k)
        {
            NValue = new List<double>();
            NValue.Add(v);
        }

        public DoubleArray(string k, List<double> v) : base(k)
        {
            NValue = v;
        }

        public DoubleArray(DoubleNode dn) : base(dn.NKey)
        {
            NValue = new List<double>();
            NValue.Add(dn.NValue);
        }

        public DoubleArray(DoubleArray da) : base(da.NKey)
        {
            NValue = da.NValue;
        }

        public Boolean add(double v)
        {
            if (nValue.Contains(v))
            {
                return false;
            }
            else
            {
                nValue.Add(v);
                return true;
            }
        }

        public Boolean remove(double v)
        {
            if (nValue.Contains(v))
            {
                nValue.Remove(v);
                return true;
            }
            else
            {
                return false;
            }
        }

        public override string ToString()
        {
            return NKey + ": " + String.Join(", ", NValue);
        }
    }
}
