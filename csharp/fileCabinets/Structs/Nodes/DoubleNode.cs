using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;

namespace csFileCabinets.Structs
{
    public class DoubleNode : BaseNode
    {
        private double nValue;

        public DoubleNode() : base() { }

        public DoubleNode(string k, double v) : base(k)
        {
            nValue = v;
        }

        [XmlElement("nValue")]
        public double NValue { get => nValue; set => nValue = value; }
    }
}
