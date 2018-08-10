using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;
using csFileCabinets.Structs.Arrays;

namespace csFileCabinets.Structs
{
    [XmlInclude(typeof(StringNode))]
    [XmlInclude(typeof(IntegerNode))]
    [XmlInclude(typeof(DoubleNode))]
    [XmlInclude(typeof(BooleanNode))]
    [XmlInclude(typeof(FKLNode))]
    [XmlInclude(typeof(IntegerArray))]
    [XmlInclude(typeof(DoubleArray))]
    [XmlInclude(typeof(StringArray))]
    [Serializable]
    public abstract class BaseNode
    {
        private string nKey;

        public BaseNode() { }

        public BaseNode(string k)
        {
            NKey = k;
        }

        [XmlElement("nKey")]
        public string NKey { get => nKey; set => nKey = value; }
    }
}
