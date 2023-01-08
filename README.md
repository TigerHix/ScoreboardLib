# ScoreboardLib
A flicker-free scoreboard library with support of text up to 48 characters.

What is ScoreboardLib?
--------------
ScoreboardLib is a flexiable library for adding pretty, animated scoreboards to your plugin without requiring you to figure out how to get rid of random flickers or limitations. This library is introduced to dealt with following problems in the original API and similar libraries:
* Scoreboards cannot display text of more than 16 characters.
* Scoreboards cannot display the same text more than once.
* The scoreboard is flickering all the time.
* Random disappearance of lines.

Any screenshots?
--------------
![Preview](http://i.imgur.com/eJgctc9.gif)

Other reasons to use ScoreboardLib?
--------------
* Simple to use. You just have to decide the user interface, ScoreboardLib already got the backend handled.
* Displays up to 48 characters instead of 16.
* Easy to implement animated text with help of `ScrollableString` and `HighlightedString`.
* Designed to be scalable and flexible.
* Performant. ScoreboardLib doesn't create a scoreboard every time the content is updated.
* Can be used as a standalone plugin, or be shaded into your project.

How do I add it to my project?
--------------
Simply add the following to your `pom.xml`.

    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependency>
        <groupId>com.github.TigerHix</groupId>
        <artifactId>ScoreboardLib</artifactId>
        <version>master-SNAPSHOT</version>
    </dependency>

Now you are able to create your own pretty scoreboards.

How do I use it?
--------------
First, you have to decide whether you use ScoreboardLib as a standalone plugin, or you just go shade it into your own plugin. For the latter case, you have to add following code to your onEnable():

```java
ScoreboardLib.setPluginInstance(this);
```

To let ScoreboardLib holds a reference to your plugin and hence able to schedule tasks, register events, etc.

For the scoreboard itself, here is an usage example:

```java
for (Player player: getServer().getOnlinePlayers()) {
	Scoreboard scoreboard = ScoreboardLib.createScoreboard(player)
		.setHandler(new ScoreboardHandler() {

    		private final ScrollableString scroll = new ScrollableString(Strings.format("&aThis string is scrollable!"), 40, 0);
    		private final HighlightedString highlighted = new HighlightedString("This string is highlighted!", "&6", "&e");
    
    		@Override
    		public String getTitle(Player player) {
    			return null;
    		}
    
    		@Override
    		public List<Entry> getEntries(Player player) {
    			return new EntryBuilder()
    				.next("    " + scroll.next())
    				.next("    " + highlighted.next())
    				.blank()
    				.next("    &b&lCURRENT TIME MILLIS")
    				.next("    " + System.currentTimeMillis())
    				.blank()
    				.next("    &c&lCURRENT NANO TIME")
    				.next("    " + System.nanoTime())
    				.blank()
    				.next("    &7This line is equivalent to another line")
    				.next("    &7This line is equivalent to another line")
    				.blank()
    				.build();
    		}

	    })
	    .setUpdateInterval(2l);
	scoreboard.activate();
}
```

Which would display a scoreboard as shown in the above gif to all online players.

To remove the scoreboard, use:

```java
scoreboard.deactivate();
```

That's really much of it. If you want to extend the functionalities somehow, simply create a new class that extends `SimpleScoreboard`, and start overriding methods, creating constructors, etc.

License
--------------
ScoreboardLib is licensed under the [GNU Lesser General Public License (Version 3)](https://github.com/TigerHix/ScoreboardLib/blob/master/LICENSE).
