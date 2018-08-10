using System;
using System.Collections.Generic;
using System.Text;

namespace csFileCabinets.Structs
{
    public class ArrayNode : BaseNode
    {
        private List<Object> nValue;

        public ArrayNode() : base() { }

        public ArrayNode(string k): base(k)
        {
            nValue = new List<object>();
        }

        public ArrayNode(string k, Object v) : base(k)
        {
            if(nValue == null)
            {
                nValue = new List<object>();
            }
            nValue.Add(v);
        }

        public bool addObject(Object o)
        {
            if (!nValue.Contains(o))
            {
                nValue.Add(o);
                return true;
            } else
            {
                return false;
            }
        }

        public bool removeObject(Object o)
        {
            if (nValue.Contains(o))
            {
                nValue.Remove(o);
                return true;
            } else
            {
                return false;
            }
        }


        public List<Object> getArray()
        {
            return nValue;
        }
        public void setArray(List<Object> l)
        {
            nValue = l;
        }

        public override string ToString()
        {
            return NKey +": "+nValue.ToString();
        }
    }
}
