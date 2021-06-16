# flappy-bird-demo

This is the original Flappy Bird Demo updated to use the latest
incarnation of Figwheel.

![screenshot](https://user-images.githubusercontent.com/2624/42334602-b4e0cc1a-804b-11e8-9d44-4b38ee4697f6.png)

Read the [blog post][flappy-bird-blog-post] about this flappy bird demo.

Watch the 6 minute [video][figwheel-demo-video]

Checkout the documentation on [figwheel-main][figwheel-main] to go further!

## Usage

#### Via Leiningen

Make sure you have the [latest version of leiningen installed][install-lein]

Clone this repo:

```shell
$ git clone https://github.com/bhauman/flappy-bird-demo-new.git
```

Change into the flappy-bird-demo-new directory and run:

```shell
$ lein fig:build
```

#### Via Clojure Tools

First we will want to [install][CLI tools] the `clj` and `clojure` [command line
tools][CLI tools].

Clone this repo:

```shell
$ git clone https://github.com/bhauman/flappy-bird-demo-new.git
```

Change into the flappy-bird-demo-new directory and run:

```shell
$ clj -A:build
```

Run the command below at the project root to generate cljs-dummy files in the project. 
The code doesn't really do anything, we just want it there to increase the number of files that has to be downloaded.
Each file is 46kB-ish. 
Then try to start the project and see how much time it takes to do a page refresh.
Be wary though, if you set the number of generated files too high,
the initial compile and page refresh will take a lot of time. 
I recommend starting with 10 files then increasing to 100, 200, 400, 800, 1600, 3200 
When you get to around a thousand files you probably get the idea.
Trying it with several thousands files really starts sucking the life out of you.

```shell
$ clj -m gen 10
```

## License

Copyright © 2018 Bruce Hauman

Distributed under the [Eclipse Public License](LICENSE) either version 1.0 or any
later version.

[figwheel-demo-video]: https://www.youtube.com/watch?v=KZjFVdU8VLI 
[flappy-bird-blog-post]: http://rigsomelight.com/2014/05/01/interactive-programming-flappy-bird-clojurescript.html
[figwheel-main]: https://github.com/bhauman/figwheel-main
[install-lein]: https://github.com/technomancy/leiningen#installation
[CLI Tools]: https://clojure.org/guides/getting_started#_installation_on_mac_via_code_brew_code
