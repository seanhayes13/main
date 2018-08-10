using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;

namespace csFileCabinets.Structs
{
    [Serializable]
    [XmlInclude(typeof(BaseNode))]
    [XmlType("stringNode")]
    public class StringNode : BaseNode
    {
        private string nValue;

        public StringNode() : base() { }

        public StringNode(string k, string v) : base(k)
        {
            NValue = v;
        }

        [XmlElement("nValue")]
        public string NValue { get => nValue; set => nValue = value; }

        public override string ToString()
        {
            return NKey + ": " + NValue;
        }
    }
}
