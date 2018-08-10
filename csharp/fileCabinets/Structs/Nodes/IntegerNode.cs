using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;

namespace csFileCabinets.Structs
{
    public class IntegerNode : BaseNode
    {
        private int nValue;

        public IntegerNode() : base() { }

        public IntegerNode(string k, int v) : base(k)
        {
            NValue = v;
        }

        [XmlElement("nValue")]
        public int NValue { get => nValue; set => nValue = value; }

        public override string ToString()
        {
            return NKey + ": " + NValue;
        }
    }
}
