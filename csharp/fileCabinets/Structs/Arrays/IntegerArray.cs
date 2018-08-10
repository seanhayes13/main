using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csFileCabinets.Structs.Arrays
{
    public class IntegerArray : BaseNode
    {
        private List<int> nValue;

        public List<int> NValue { get => nValue; set => nValue = value; }

        public IntegerArray() { }

        public IntegerArray(string k, int v) : base(k)
        {
            NValue = new List<int>();
            NValue.Add(v);
        }

        public IntegerArray(string k, List<int> v) : base(k)
        {
            NValue = v;
        }

        public IntegerArray(IntegerNode intNode) : base(intNode.NKey)
        {
            NValue = new List<int>();
            NValue.Add(intNode.NValue);
        }

        public IntegerArray(IntegerArray ia) : base(ia.NKey)
        {
            NValue = ia.NValue;
        }

        public Boolean add(int v)
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

        public Boolean remove(int v)
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
