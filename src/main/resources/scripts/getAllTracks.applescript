on run argv
	tell application "iTunes"
		set allInfo to {}

		tell (some playlist whose persistent ID is item 1 of argv)
			set end of allInfo to get persistent ID of file tracks
			set end of allInfo to get name of file tracks
			set end of allInfo to get album of file tracks
			set end of allInfo to get artist of file tracks
			set end of allInfo to get track number of file tracks
			set end of allInfo to get disc number of file tracks
			set end of allInfo to get location of file tracks
		end tell
		
		return allInfo
	end tell
end run