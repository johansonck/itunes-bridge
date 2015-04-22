on run argv
	tell application "iTunes"
		tell (some playlist whose persistent ID is item 1 of argv)
			get count of file tracks
		end tell
	end tell
end run