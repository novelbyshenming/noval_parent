namespace java thrift.generated
namespace py py.thrift.generated

typedef i16 short
typedef i32 int
typedef i16 long
typedef bool boolean
typedef string String

struct NovelChapterContext{

     1: optional String context,
     2: optional String lastChapter,
     3: optional String nextChapter;
 }


struct NovelChapter{

   1: optional String novelChapterJson,

}

service NovelService{

    /*根据 章节的url 来动态爬取 小说内容   用于构建小说页面     */
    NovelChapterContext getNovelChapterContextByChapterUrl(1:required String chapterUrl);
    /*根据  小说的url 来动态爬取 小说章节信息和url    */
    NovelChapter getNovelChapterListByNovelUrl(1:required String novelUrl);
}