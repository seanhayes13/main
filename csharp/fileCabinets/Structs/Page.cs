using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;

namespace csFileCabinets.Structs
{
    /*
     * Renaming this class from Page to Page to remove confusion with 
     * System.Windows.Controls.Page
     */
    [Serializable]
    [XmlType("page")]
    public class Page
    {
        private List<BaseNode> nodes;
        
        private int id;

        public Page() { }

        public Page(int i)
        {
            nodes = new List<BaseNode>();
            id = i;
        }

        public int Id { get => id; }

        [XmlElement("nodes")]
        public List<BaseNode> Nodes { get => nodes; set => nodes = value; }

        [XmlAttribute("id")]
        public int Id1 { get => id; set => id = value; }

        public bool addNode(BaseNode bn)
        {
            foreach(BaseNode bn1 in nodes)
            {
                if (bn1.NKey.Equals(bn.NKey))
                {
                    Console.WriteLine("fail add");
                    return false;
                }
            }
            nodes.Add(bn);
            return true;
        }

        public bool contain(string s)
        {
            foreach(BaseNode bn in nodes)
            {
                if (bn.NKey.Equals(s))
                {
                    return true;
                }
            }
            return false;
        }

        public bool deleteNodeByKey(string s)
        {
            bool confirm = false;
            int found = -1;
            if (nodes.Count > 0)
            {
                for(int i = 0; i < nodes.Count; i++)
                {
                    if (nodes[i].NKey.Equals(s))
                    {
                        found = i;
                    }
                }
            }
            if (found > 0)
            {
                nodes.RemoveAt(found);
                confirm = true;
            }
            return confirm;
        }

        public List<BaseNode> getNodes()
        {
            return nodes;
        }

        public BaseNode selectNode(string s)
        {
            BaseNode result = null;
            foreach(BaseNode bn in nodes)
            {
                if (bn.NKey.Equals(s))
                {
                    result = bn;
                }
            }
            return result;
        }
    }
}
