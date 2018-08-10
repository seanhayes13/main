using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using csFileCabinets.Structs;

namespace csFileCabinets.Utility
{
    class RedirectInput
    {

        private static Boolean isDbl(String s)
        {
            try
            {
                Double.Parse(s);
                return true;
            } catch
            {
                return false;
            }
        }

        private static Boolean isInt(String s)
        {
            try
            {
                int.Parse(s);
                return true;
            }
            catch
            {
                return false;
            }
        }

        public static BaseNode redirectInput(String k, String s)
        {
            BaseNode result = null;
            if (s.Equals("true"))
            {
                result = new BooleanNode(k, true);
            }
            else if (s.Equals("false"))
            {
                result = new BooleanNode(k, false);
            }
            else if (isInt(s))
            {
                result = new IntegerNode(k, int.Parse(s));
            }
            else if (isDbl(s))
            {
                result = new DoubleNode(k, Double.Parse(s));
            }
            else
            {
                result = new StringNode(k, s);
            }
            return result;
        }
    }
}
