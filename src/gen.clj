(ns gen
	(:require [clojure.java.io :as io]
											[clojure.string :as str]))

(def number-of-files 1)

(defn safe-delete [file-path]
  (if (.exists (clojure.java.io/file file-path))
    (try
      (clojure.java.io/delete-file file-path)
      (catch Exception e (str "exception: " (.getMessage e))))
    false))

(defn delete-directory [directory-path]
  (let [directory-contents (file-seq (clojure.java.io/file directory-path))
        files-to-delete (filter #(.isFile %) directory-contents)]
    (doseq [file files-to-delete]
      (safe-delete (.getPath file)))
    (safe-delete directory-path)))

(defn generate-files []
(doall (for [n (range 1 (inc number-of-files))]
      (spit (str "src/flappy_bird_demo/generated/test_" n ".cljs")
            (str "(ns flappy-bird-demo.generated.test-" n ")"
            "\n(defn plus [a b] (+ a b))"
            "\n(defn minus [a b] (- a b))"
            "\n(defn multiply [a b] (* a b))"
            "\n(defn devide [a b] (/ a b))"
            "\n(defn tekst [navn] (plus 10 10) 
            (minus 10 10)
            (multiply 10 10) 
            (divide 10 10) 
            (println \"This is just a very long text, to add some extra kB to the file.
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc mollis laoreet ex ac vulputate. Integer condimentum turpis et elementum auctor. Maecenas fringilla fringilla nibh. Donec tortor orci, vulputate in purus eu, congue ultrices neque. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi commodo ex eu nulla lacinia molestie. Etiam sit amet ex diam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla ante ante, dapibus a elementum non, fermentum eget sem. Etiam in facilisis orci. Maecenas mauris nulla, mollis eget venenatis et, tincidunt quis sem. Nullam gravida massa a orci pharetra, in facilisis ex vehicula. Etiam metus purus, euismod non risus ut, fringilla molestie nunc. Nunc fermentum dolor vitae justo ullamcorper elementum. Curabitur in quam vitae elit lacinia pulvinar id id massa.

Nunc volutpat elit in vestibulum mattis. Integer dictum tortor vel malesuada blandit. Vivamus et augue at lorem tincidunt sagittis. Nam suscipit facilisis porttitor. Fusce a lectus consequat, finibus velit quis, imperdiet nisi. Suspendisse mi tortor, mollis ac vehicula nec, congue eu sapien. Sed mollis nibh justo. Suspendisse vulputate ante eu purus tempus efficitur. In congue dui quis pulvinar aliquet. Nullam est velit, fringilla eu metus vel, scelerisque elementum nisl.

Etiam pharetra rhoncus molestie. Nam pharetra nulla accumsan ipsum ultrices, sed feugiat augue molestie. Proin vel consequat orci, at lobortis risus. Pellentesque convallis nibh ut erat luctus ultrices in at sapien. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vivamus ullamcorper ultricies consectetur. Vivamus aliquam vulputate lacus at euismod. Donec finibus enim risus, eget tincidunt neque sollicitudin vel. Pellentesque massa quam, vehicula non ullamcorper sit amet, blandit vitae lectus.

Donec quis viverra diam. Ut eget nisl velit. Donec nec molestie nisl. Sed mollis accumsan porttitor. Vestibulum in felis imperdiet, luctus urna ac, mattis quam. Praesent sit amet dolor velit. In dictum urna urna, nec dapibus diam porttitor blandit. Mauris eu lacus sodales, sodales mauris eget, lobortis justo. Donec sollicitudin imperdiet massa, at laoreet est. Maecenas tempus eu nisl vel porttitor. Proin vitae eleifend nisi. Etiam porta metus et ipsum convallis mattis.

Morbi placerat nunc sit amet mi aliquam sagittis. Mauris tortor nisi, porta in posuere at, porttitor non quam. Nulla lacinia dapibus nunc nec venenatis. Etiam aliquet massa sit amet rhoncus vestibulum. Nullam pulvinar tincidunt magna, eleifend aliquet leo. Nullam vulputate rutrum dolor, ut sodales eros faucibus eget. Integer eu metus sed odio mollis finibus nec et urna. Mauris tincidunt accumsan felis, at dictum tortor.

Morbi quam dui, pulvinar ac metus non, iaculis consequat purus. Donec vitae tortor viverra, placerat mauris quis, gravida urna. Pellentesque rhoncus varius diam, a sollicitudin dui gravida vel. Suspendisse a sem eget metus tincidunt viverra. Suspendisse tempor eros velit, id condimentum orci porttitor vel. Ut scelerisque fermentum nibh id molestie. Sed sed lobortis augue, nec placerat dui. Nam dui nulla, faucibus non tempus ut, aliquam et elit. Praesent volutpat non nisi vitae rhoncus. Ut vulputate sollicitudin eros, vitae faucibus lectus condimentum sit amet. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vestibulum lobortis, metus vel tincidunt tincidunt, augue tellus feugiat diam, sit amet dictum lacus justo in dolor. Curabitur in mauris a est auctor elementum. Nullam ut tortor eros.

Aenean nec ligula pellentesque, tincidunt massa eu, tincidunt felis. Morbi convallis velit ac nisl malesuada, eget fringilla massa lobortis. Vivamus luctus nulla pellentesque, condimentum lacus id, porttitor turpis. Fusce sollicitudin, libero id fermentum lobortis, tellus sem faucibus nisl, quis iaculis elit mauris ut magna. Aenean eget sem bibendum, rutrum erat efficitur, eleifend erat. Suspendisse porttitor a nibh sit amet vestibulum. Nullam venenatis nibh sit amet fermentum facilisis. Mauris tristique, nisi vitae finibus euismod, dolor ex iaculis lorem, vel ultricies est nisi at arcu. Nulla tortor metus, dignissim at arcu non, malesuada consequat dolor.

Donec sagittis ipsum sit amet massa ullamcorper posuere. In viverra risus vel felis porta venenatis. Integer congue sit amet orci et ullamcorper. Fusce venenatis tincidunt nunc ac venenatis. Aenean vel pharetra justo. Maecenas vulputate, magna nec molestie mattis, nulla dolor vestibulum eros, quis tempus justo libero a tortor. Proin suscipit ex erat, ac bibendum lectus placerat quis. Praesent sodales risus sed convallis vehicula. Suspendisse dictum nunc libero, sed pellentesque justo scelerisque ac. Aliquam condimentum, dolor et auctor semper, nisi odio lacinia sem, nec semper est augue et velit. Aliquam ac volutpat nulla, nec ornare ipsum.

Suspendisse potenti. Nam eget venenatis enim. In tincidunt felis velit, quis scelerisque risus pulvinar euismod. Donec a fringilla risus, ac bibendum lectus. Sed in enim nunc. Cras lacinia convallis pretium. Integer ipsum enim, ultricies ac malesuada eu, rutrum nec ipsum. Pellentesque vulputate eu mi sit amet lobortis. Aenean fermentum pretium dapibus.

Nunc tellus lacus, egestas ac venenatis vitae, dictum sit amet diam. Duis gravida lobortis ante in finibus. Nulla congue, lorem eget faucibus sollicitudin, justo sem finibus velit, id faucibus enim mi ac urna. Praesent gravida accumsan tempus. Aenean nec congue ipsum, non tempor orci. Phasellus massa odio, semper eu dolor sed, aliquam feugiat dui. Duis auctor molestie sapien in faucibus. Cras viverra lectus vel arcu sollicitudin, at placerat tortor tincidunt. Mauris sed arcu iaculis, blandit nisl ut, euismod nibh. Suspendisse suscipit velit ante, a fringilla dolor egestas eget. Praesent et sollicitudin neque. Phasellus nibh magna, faucibus sit amet est id, rhoncus porta tellus. Aenean et dolor nec sem sollicitudin ultricies quis in nisi. Vestibulum in convallis nulla.

Cras vitae felis quis erat scelerisque venenatis tristique at massa. Mauris cursus eu quam a semper. In sed neque sit amet lectus ultrices bibendum aliquam at libero. Nam aliquet, velit ut ultricies gravida, sapien urna volutpat quam, eu molestie velit orci nec lectus. Mauris convallis mauris elit, ut tempor nisi fringilla id. Suspendisse rutrum, purus sed tristique luctus, nibh nisi auctor turpis, vel viverra erat neque et metus. Aenean scelerisque nisl ut risus tempor molestie. Quisque ligula urna, bibendum nec pretium vel, bibendum sed neque. Quisque sed posuere sapien. Etiam condimentum felis vitae massa malesuada, sit amet auctor arcu accumsan.

Vestibulum varius nunc vel enim volutpat interdum. Mauris ut leo vitae nunc elementum efficitur. Fusce eget tellus et odio finibus sodales. Suspendisse consectetur semper justo, a suscipit nunc malesuada vitae. Morbi consequat nunc sit amet sem molestie, sed interdum dui blandit. Duis tincidunt consectetur ultricies. Integer metus mauris, lacinia ac pellentesque vitae, aliquet non purus. Quisque vel lacus lacus. Vestibulum eu viverra neque. Mauris ac magna nisl. Etiam tincidunt accumsan neque, at dictum libero posuere imperdiet. Phasellus ornare ornare magna, ac commodo odio pellentesque a. Sed facilisis, lorem in faucibus auctor, dui mi finibus elit, at dignissim sem dui sit amet felis. Nullam ullamcorper metus placerat scelerisque pulvinar. Etiam tempor vitae risus eget condimentum. Phasellus blandit mollis tortor, viverra tincidunt libero gravida non.

Etiam neque mi, egestas nec cursus tincidunt, fringilla eu nulla. Aenean felis turpis, varius rhoncus venenatis a, sagittis vulputate justo. Praesent faucibus ultrices ipsum hendrerit dapibus. Quisque sit amet neque at nulla viverra pellentesque. Nullam semper ut ipsum accumsan ullamcorper. Proin dui augue, aliquam vel condimentum ut, mollis et lacus. Mauris tristique magna quis molestie varius. Duis lobortis blandit mi, a gravida nibh congue ac. Sed at neque eleifend, commodo ipsum sed, mattis quam. Fusce gravida justo at est feugiat tempor eget vel massa. Praesent et ipsum tortor. Fusce malesuada semper tellus, ut semper neque. Vivamus a pulvinar massa, vel lacinia quam.

Praesent non lorem massa. Maecenas sed leo vestibulum, iaculis nunc a, egestas erat. Aliquam laoreet, massa eget hendrerit lobortis, nisl ipsum hendrerit diam, non condimentum tellus nulla ut mi. Aliquam erat volutpat. Ut massa leo, efficitur vitae gravida porta, eleifend non ante. Curabitur pulvinar odio quis leo tempor lobortis. In dui elit, elementum non dapibus sit amet, lobortis eget elit. Maecenas pretium imperdiet sem non rutrum. Pellentesque bibendum posuere diam, ut efficitur tellus viverra sed. Suspendisse mattis massa ut augue laoreet consequat.

Nulla mattis sit amet erat ac fermentum. Etiam id feugiat quam. Aliquam luctus tortor sed libero sollicitudin suscipit. Integer quis nunc fermentum, varius libero a, elementum metus. Cras quis aliquam nulla. Sed lobortis ipsum metus, in fermentum sem convallis vitae. Proin et neque sed leo ullamcorper sollicitudin a in odio. Aenean ac tincidunt erat.

Suspendisse vulputate risus sit amet ex placerat fringilla. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque aliquet eleifend ligula, et lacinia neque ornare at. Quisque lacinia molestie viverra. Sed hendrerit sed nunc ac pellentesque. Morbi bibendum viverra velit, ac vulputate odio congue sed. Curabitur hendrerit lorem commodo, laoreet nunc ut, maximus lorem. Phasellus faucibus ullamcorper metus, ut ultricies nisi venenatis vel. Vivamus nec ligula in urna egestas pulvinar. Maecenas lacus velit, pharetra eget cursus a, commodo non leo. Sed interdum nisl ut nibh ultricies lacinia.

Vestibulum velit massa, venenatis vitae rutrum vel, malesuada quis eros. Suspendisse et lacus nulla. Aliquam scelerisque efficitur nisi at mattis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Curabitur quis hendrerit arcu, vel euismod mi. Ut mollis, ex sit amet imperdiet sagittis, nulla turpis interdum diam, sit amet mattis turpis libero vitae est. Etiam dictum massa nec aliquet condimentum. Praesent id semper dolor. Praesent in egestas ex, eu porta elit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed luctus magna tellus, hendrerit laoreet nisl condimentum id. Cras in iaculis purus. Donec nec orci ut lacus dignissim pretium ac vitae arcu.

Pellentesque venenatis varius diam. Donec ultrices sit amet ante eget auctor. Sed luctus in mauris vel laoreet. Vestibulum imperdiet ipsum a odio tristique, a ultricies justo scelerisque. Proin consequat tristique sapien, sagittis auctor mi blandit vel. Integer maximus posuere lacus, ac congue ex euismod non. Donec odio massa, lacinia tincidunt augue sed, venenatis mattis arcu. Vestibulum ac tortor eu ex iaculis rhoncus consequat a tellus. Nam ipsum lacus, porttitor fringilla condimentum non, venenatis sed nisi. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum iaculis vestibulum metus in efficitur. Aenean malesuada sed quam tempor mollis. Suspendisse sollicitudin leo quis tempus eleifend. Etiam ut ultricies libero. Vivamus vel volutpat nulla. Sed at tincidunt lectus.

Aliquam tincidunt dui ut ex imperdiet, ac congue sem aliquet. Nulla id feugiat est, et imperdiet enim. Donec in tincidunt velit. Nulla pharetra quam eget sem mattis iaculis. Aliquam blandit sollicitudin laoreet. Nunc et nisi faucibus tellus vulputate accumsan quis eget nibh. Etiam tristique et ante in condimentum. Fusce faucibus justo metus, aliquet bibendum lorem venenatis id. Sed sagittis magna a neque placerat, ac luctus nisi suscipit. Quisque laoreet iaculis magna eu dignissim. Suspendisse placerat arcu nec nibh pretium sollicitudin.

Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam viverra non mauris a pharetra. Fusce arcu tellus, cursus condimentum elementum sed, bibendum at ex. Mauris mollis tellus vitae lobortis luctus. Maecenas suscipit condimentum eleifend. Proin porttitor justo a consequat accumsan. Ut molestie metus nec odio consequat, non tincidunt dolor pharetra. Phasellus posuere elit eu arcu sodales, vitae hendrerit diam facilisis. Duis commodo odio nec congue rutrum. Pellentesque id felis sit amet mauris pulvinar vestibulum.\"))")))))

(defn generate-file-mother []
				(let [required (str/join "\n" 
          		(for [n (range 1 (inc number-of-files))]
          				(str "[flappy-bird-demo.generated.test-" n "]")))]
    (spit "src/flappy_bird_demo/generated/mother.cljs"
       (str "(ns flappy-bird-demo.generated.mother (:require " required "))"))))

(defn -main [& args]
		(prn (str "Starting to generate " number-of-files " files"))
		(delete-directory "src/flappy_bird_demo/generated")
		(.mkdir (java.io.File. "src/flappy_bird_demo/generated"))
  (generate-files)
  (generate-file-mother)
  (prn "Finished generating files"))