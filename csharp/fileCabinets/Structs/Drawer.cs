using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;

namespace csFileCabinets.Structs
{
    [Serializable]
    [XmlRoot("drawer")]
    [XmlInclude(typeof(Folder)), XmlInclude(typeof(Page)), XmlInclude(typeof(BaseNode))]
    public class Drawer
    {
        private List<Folder> folders;
        private List<Page> pages;
        private string drawerName;
        private int pageCount = 1;

        public Drawer() { }

        public Drawer(Drawer d)
        {
            if (Folders == null && d.Folders != null)
            {
                Folders = new List<Folder>();
                Folders = d.Folders;
            }
            if (Pages == null && d.Pages != null)
            {
                Pages = new List<Page>();
                Pages = d.Pages;
            }
        }

        public Drawer(string s)
        {
            DrawerName = s;
        }

        public void addFolder(Folder f)
        {
            if(folders == null)
            {
                folders = new List<Folder>();
            }
            folders.Add(f);
        }

        public void addPage(Page p)
        {
            if(pages == null)
            {
                pages = new List<Page>();
            }
            pages.Add(p);
        }

        public Boolean deleteFolder(String tgt)
        {
            Boolean confirm = false;
            int found = -1;
            if (folders.Count == 0)
            {
                Console.WriteLine("Nothing to delete...");
            }
            else
            {
                for (int i = 0; i < folders.Count; i++)
                {
                    if (folders[i].FolderName.Equals(tgt))
                    {
                        found = i;
                    }
                }
                folders.RemoveAt(found);
                confirm = true;
            }
            return confirm;
        }
        public Boolean deletePage(int tgt)
        {
            Boolean confirm = false;
            int found = -1;
            if (pages.Count == 0)
            {
                Console.WriteLine("Nothing to delete...");
            }
            else
            {
                for (int i = 0; i < pages.Count; i++)
                {
                    if (pages[i].Id == (tgt))
                    {
                        found = i;
                    }
                }
                pages.RemoveAt(found);
                confirm = true;
            }
            return confirm;
        }

        public Folder getFolder(List<string> tgt)
        {
            List<string> working = new List<string>(tgt);
            Folder result;
            if (working.Count == 1)
            {
                result = this.getFolder(working[0]);
                tgt.RemoveAt(0);
                return result;
            }
            else
            {
                String a = working[0];
                working.RemoveAt(0);
                Folder temp = this.getFolder(a);
                if (working.Count == 0)
                {
                    result = temp;
                }
                result = getSubFolder(temp, working);
            }
            return result;
        }

        public Folder getFolder(string tgt)
        {
            foreach (Folder f in folders)
            {
                if (f.FolderName.Equals(tgt))
                {
                    return f;
                }
            }
            return null;
        }

        public Page getPage(int i)
        {
            foreach (Page p in pages)
            {
                if (p.Id == i) return p;
            }
            return null;
        }

        private Folder getSubFolder(Folder f, List<string> s)
        {
            if (s.Count == 1)
            {
                Folder result = f.getSubFolder(s[0]);
                s.RemoveAt(0);
                return result;//problem
            }
            else
            {
                String t = s[0];
                Folder temp = f.getSubFolder(t);
                if (s.Count == 0)
                {
                    return temp;
                }
                return getSubFolder(temp, s);//problem
            }
        }

        public int incrementID()
        {
            return PageCount++;
        }

        //[XmlElement(ElementName ="drawerName",Namespace ="drawerNameSpace")]
        [XmlAttribute("dName")]
        public string DrawerName { get => drawerName; set => drawerName = value; }

        [XmlArray(ElementName = "pagesList")]
        [XmlArrayItem(Type = typeof(Page))]
        public List<Page> Pages { get => pages; set => pages = value; }

        [XmlArray("foldersList")]
        [XmlArrayItem(Type = typeof(Folder))]
        public List<Folder> Folders { get => folders; set => folders = value; }

        [XmlAttribute("pageCount")]
        public int PageCount { get => pageCount; set => pageCount = value; }
    }
}
