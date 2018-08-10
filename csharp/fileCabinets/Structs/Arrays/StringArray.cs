using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csFileCabinets.Structs.Arrays
{
    public class StringArray : BaseNode
    {
        private List<string> nValue;

        public List<string> NValue { get => nValue; set => nValue = value; }

        public StringArray() { }

        public StringArray(string k, string v) : base(k)
        {
            NValue = new List<string>();
            NValue.Add(v);
        }

        public StringArray(string k, List<string> v) : base(k)
        {
            NValue = v;
        }

        public StringArray(StringNode sn) : base(sn.NKey)
        {
            NValue = new List<string>();
            NValue.Add(sn.NValue);
        }

        public StringArray(StringArray sa) : base(sa.NKey)
        {
            NValue = sa.NValue;
        }

        public Boolean add(string v)
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

        public Boolean remove(string v)
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
