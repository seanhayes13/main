using System;
using System.Collections.Generic;
using System.Text;

namespace csFileCabinets.Structs
{
    public class BooleanNode : BaseNode
    {
        private bool nValue;

        public BooleanNode() : base() { }

        public BooleanNode(string k, bool v) : base(k)
        {
            nValue = v;
        }

        public bool NValue { get => nValue; set => nValue = value; }

        public override string ToString()
        {
            if (NValue) return NKey + ": true";
            else return NKey + ":  false";
        }
    }
}
