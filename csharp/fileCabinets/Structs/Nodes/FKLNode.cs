using System;
using System.Collections.Generic;
using System.Text;

namespace csFileCabinets.Structs
{
    //Come back to this node
    public class FKLNode :BaseNode
    {
        private List<ForeignLink> keyList;

        public FKLNode() : base() { }

        public FKLNode(string k,  string d, string f, int p) : base(k)
        {
            keyList = new List<ForeignLink>();            
        }

        public FKLNode(string k, ForeignLink fl): base(k)
        {
            if(keyList == null)
            {
                keyList = new List<ForeignLink>();
            }
            keyList.Add(fl);
        }

        public Boolean addList(ForeignLink fl)
        {
            if (keyList.Contains(fl))
            {
                return false;
            }
            else
            {
                keyList.Add(fl);
                return true;
            }
        }

        public Boolean check(ForeignLink fl)
        {
            if (keyList == null)
            {
                return false;
            }
            else
            {
                foreach (ForeignLink flIter in keyList)
                {
                    if (flIter.equals(fl))
                    {
                        return true;
                    }
                }
                return false;
            }
        }

        public void removeList(ForeignLink fl)
        {
            ForeignLink rem = null;
            foreach (ForeignLink fIter in keyList)
            {
                if (fIter.equals(fl))
                {
                    rem = fIter;
                    break;
                }
            }
            if (rem != null)
            {
                keyList.Remove(rem);
            }
            if (keyList.Count == 0)
            {
                keyList = null;
            }
        }

        public override string ToString()
        {
            List<string> temp = new List<string>();
            foreach (ForeignLink fl in keyList)
            {
                temp.Add(fl.ToString());
            }
            return NKey + ": " + String.Join(",", temp);
        }

        //Come back to this one after updating original in Java
        //public Boolean check(string d, string f, int p)
        //{
        //    if (keyList == null) return false;
        //    else
        //    {
        //        string tgt = d + ":" + f + ":" + p;
        //        if (keyList.Contains(tgt)) return true;
        //        else return false;
        //    }
        //}

        //getter and setter
        public List<ForeignLink> KeyList { get => keyList; set => keyList = value; }
    }
}
