using csFileCabinets.Structs;
using System;
using System.IO;
using System.Xml;
using System.Xml.Serialization;

namespace csFileCabinets.Utility
{
    class ReadWrite
    {
        /*
         * Need to check online and make sure that the format from here matches the format from
         * Java version to allow cross compatibility
         */
        public static void writeToXml(Drawer d)
        {
            Console.WriteLine("Starting to write " + d.DrawerName);
            XmlSerializer xs = new XmlSerializer(typeof(Drawer), new Type[] { typeof(Folder), typeof(Page), typeof(BaseNode) });

            XmlWriterSettings settings = new XmlWriterSettings
            {
                Indent = true,
                IndentChars = "  ",
                NewLineChars = "\r\n",
                NewLineHandling = NewLineHandling.Replace
            };

            using (var output = new StreamWriter(d.DrawerName+".xml"))
            {
                using (XmlWriter writer = XmlWriter.Create(output,settings))
                {
                    xs.Serialize(writer, d);
                    output.Flush();
                }
            }
            Console.WriteLine("Finished writing " + d.DrawerName + ", returning to program");
        }

        public static Drawer readFromXml(string tgt)
        {
            Console.WriteLine("Starting to read " + tgt);
            Drawer d = null;
            XmlSerializer xr = new XmlSerializer(typeof(Drawer), new Type[] { typeof(Folder), typeof(Page), typeof(BaseNode) });
            d = (Drawer)xr.Deserialize(new XmlTextReader(tgt+".xml"));
            Console.WriteLine("Finished reading " + tgt + ", returning to program");
            return d;
        }
    }
}
