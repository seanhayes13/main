using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;

namespace csFileCabinets.Structs
{
    [Serializable]
    [XmlType("folder")]
    [XmlInclude(typeof(Page))]
    public class Folder
    {
        private List<Folder> folders;
        private List<Page> pages;
        
        private string folderName;
        
        private int idCount = 1;

        public Folder() { }

        public Folder(string fn)
        {
            folderName = fn;
        }

        public Folder(Folder f)
        {
            if(folders == null && f.folders != null)
            {
                folders = new List<Folder>();
                folders = f.folders;
            }
            if (pages == null && f.pages != null)
            {
                pages = new List<Page>();
                pages = f.pages;
            }
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
            if (pages == null)
            {
                pages = new List<Page>();
            }
            pages.Add(p);
        }

        public void deleteFolder(Folder tgt)
        {
            folders.Remove(tgt);
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
                    if (pages[i].Id == tgt)
                    {
                        found = i;
                    }
                }
                pages.RemoveAt(found);
                confirm = true;
            }
            return confirm;
        }

        //public List<Page> findMany()
        //{
        //    //Come back to this
        //}

        public Page getPage(int i)
        {
            foreach (Page p in pages)
            {
                if (p.Id == i) return p;
            }
            return null;
        }

        public Folder getSubFolder(string s)
        {
            foreach (Folder f in folders)
            {
                if (f.FolderName.Equals(s)) return f;
            }
            return null;
        }

        public int idIncrement()
        {
            return idCount++;
        }

        public override string ToString()
        {
            return "Folder: " + FolderName;
        }

        [XmlAttribute("folderName")]
        public string FolderName { get => folderName; set => folderName = value; }

        [XmlArray("foldersList")]
        [XmlArrayItem(Type = typeof(Folder))]
        public List<Folder> Folders { get => folders; set => folders = value; }

        [XmlArray("pagesList")]
        [XmlArrayItem(Type = typeof(Page))]
        public List<Page> Pages { get => pages; set => pages = value; }

        [XmlAttribute("pageCount")]
        public int IdCount { get => idCount; set => idCount = value; }
    }
}
